package com.authentication.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.dao.UserAuthenticationDao;
import com.authentication.data.CustomSpringUser;
import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.constant.ConstantValue;
import com.medical_staff.service.MedicalStaffService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserAuthenticationDao uaDao;
	@Autowired
	MedicalStaffService msService;

	public CustomUserDetailsService() {
		System.out.println("CustomUserDetailsService has been made");
	}

	@Override
	public UserDetails loadUserByUsername(String account)
			throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		UserDetails ud = getUser(account);
		return ud;
	}

	private UserDetails getUser(String account)
			throws UsernameNotFoundException {
		/*
		 * get the role 1 : Physician 2 : Medical Staff
		 */
		int role = 0;
		String[] s = account.split(":");
		account = s[0];
		role = Integer.valueOf(s[1]);
		System.out.println("username:" + account + " role:" + role);
		if (role == 1) {
			/*
			 * Physician
			 */
			List<Physician> userList = uaDao.listUser();
			Physician currentUser = null;
			System.out.println(userList.size());
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getAccount().equals(account)) {
					System.out.println(account);
					currentUser = userList.get(i);
				}
			}
			if (currentUser == null) {
				System.out.println("No User Exist");
				return null;
			}
			System.out.println("ROLE_PHYSICIAN");
			UserDetails user = new CustomSpringUser(currentUser.getAccount(),
					currentUser.getPassword(), true, true, true, true,
					getAuthorities("PHYSICIAN"), currentUser.getPhysician_id(),
					ConstantValue.PHYSICIAN, currentUser.getPhysician_name(),
					currentUser.getAccount());
			return user;
		} else if (role == 2) {
			/*
			 * Medical staff
			 */
			List<MedicalStaff> userList = msService.list();
			MedicalStaff currentUser = null;
			System.out.println(userList.size());
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getMs_account().equals(account)) {
					System.out.println(account);
					currentUser = userList.get(i);
				}
			}
			if (currentUser == null) {
				System.out.println("No User Exist");
				return null;
			}
			System.out.println("ROLE_MEDICAL_STAFF");
			UserDetails user = new CustomSpringUser(
					currentUser.getMs_account(), currentUser.getPassword(),
					true, true, true, true, getAuthorities("PHYSICIAN"),
					currentUser.getMsid(), ConstantValue.MEDICAL_STAFF,
					currentUser.getMs_name(), currentUser.getMs_account());
			return user;
		}
		return null;
	}

	/**
	 * get authorities of user
	 * 
	 * @param accountType
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthorities(String accountType) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(3);

		if (accountType.equals("PHYSICIAN")) {
			authList.add(new GrantedAuthorityImpl("ROLE_PHYSICIAN"));
		}

		if (accountType.equals("ADMIN")) {
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}

		return authList;
	}

	public static CustomSpringUser currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			CustomSpringUser cs  =(CustomSpringUser) (principal instanceof CustomSpringUser ? principal
					: null);
			if(cs != null){
				System.out.println("current user type = "+cs.getUserType());
				System.out.println("current user account = "+cs.getAccount());
			}
			return (CustomSpringUser) (principal instanceof CustomSpringUser ? principal
					: null);
		}
		return null;
	}
	
	public static boolean isPhysician(){
		CustomSpringUser cs = CustomUserDetailsService.currentUserDetails();
		return cs.getUserType().equals(ConstantValue.PHYSICIAN);
	}
	public static boolean isMedicalStaff(){
		CustomSpringUser cs = CustomUserDetailsService.currentUserDetails();
		return cs.getUserType().equals(ConstantValue.MEDICAL_STAFF);
	}
	
}