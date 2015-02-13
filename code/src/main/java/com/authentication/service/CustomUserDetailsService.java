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
import com.authentication.data.DbUser;
import com.client.data.Client;
import com.license.dao.LicenseDAO;
import com.license.data.License;

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
		UserDetails ud = getTwiddlerUser(username);
		if (ud == null) {
			ud = getAccountUser(username);
		}
		return ud;
	}

	private UserDetails getTwiddlerUser(String username)
			throws UsernameNotFoundException {
		List<DbUser> userList = uaDao.listUser();
		DbUser currentUser = null;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equals(username)) {
				System.out.println(username);
				currentUser = userList.get(i);
			}
		}
		if (currentUser == null) {
			System.out.println("No User Exist");
			return null;
		}
		UserDetails user = new User(currentUser.getName(),
				currentUser.getPassword(), true, true, true, true,
				this.getAuthorities("twiddler_admin"));

		return user;
	}

	private UserDetails getAccountUser(String username)
			throws UsernameNotFoundException {
		Client currentClient = uaDao.findClientUser(username);
		UserDetails user = null;
		// clientUser exist
		// check this client has available license
		if (currentClient == null) {
			System.out.println("No Client Exist");
			return null;
		}
		boolean hasAvailableLicense = checkLience(currentClient);
		if (!hasAvailableLicense) {
			System.out.println("No License or Expire");
			return null;
		}
		user = new User(currentClient.getAccount(),
				currentClient.getPassword(), true, true, true, true,
				this.getAuthorities("account_admin"));
		return user;
	}

	private boolean checkLience(Client currentClient) {
		List<License> licenses = lDao.listLicense();
		for (License license : licenses) {
			if (license.getCid() == currentClient.getCid()) {
				Date date = new Date();
				if (dateActive(date, license.getStart_date(),
						license.getEnd_date())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dateActive(Date date, Date start_date, Date end_date) {
		return (date.before(end_date) && date.after(start_date));
	}

	/**
	 * get authorities of user
	 * 
	 * @param accountType
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(String accountType) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(3);

		if (accountType.equals("user")) {
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		}

		if (accountType.equals("twiddler_admin")) {
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}

		if (accountType.equals("account_admin")) {
			authList.add(new GrantedAuthorityImpl("ROLE_AADMIN"));
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