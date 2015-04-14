package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.CustomSpringUser;
import com.authentication.service.CustomUserDetailsService;
import com.security.dao.SecurityDao;
import com.security.data.Security;

@Service
public class SecurityService {
	@Autowired
	SecurityDao sDao;

	public Security getSecurity() {
		// TODO Auto-generated method stub
		CustomSpringUser cs = CustomUserDetailsService.currentUserDetails();
		Integer userId =cs.getUserId();
		
		return sDao.getById(userId,cs.getUserType());
	}

	public void save(Security s) {
		// TODO Auto-generated method stub
		sDao.save(s);
	}
	
}
