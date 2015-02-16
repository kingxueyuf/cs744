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
import com.authentication.data.Physician;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserAuthenticationDao uaDao;

	public CustomUserDetailsService() {
		System.out.println("CustomUserDetailsService has been made");
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		UserDetails ud = getUser(username);
		return ud;
	}

	private UserDetails getUser(String username)
			throws UsernameNotFoundException {
		List<Physician> userList = uaDao.listUser();
		Physician currentUser = null;
		System.out.println(userList.size());
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getPhysicianName().equals(username)) {
				System.out.println(username);
				currentUser = userList.get(i);
			}
		}
		if (currentUser == null) {
			System.out.println("No User Exist");
			return null;
		}
		System.out.println("ROLE_PHYSICIAN");
		UserDetails user = new User(currentUser.getPhysicianName(),
				currentUser.getPassword(), true, true, true, true,
				this.getAuthorities("ROLE_PHYSICIAN"));

		return user;
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

	public static UserDetails currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			return (UserDetails) (principal instanceof UserDetails ? principal
					: null);
		}
		return null;
	}

}