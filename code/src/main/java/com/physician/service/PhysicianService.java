package com.physician.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.physician.dao.PhysicianDao;

@Service
public class PhysicianService {
	@Autowired
	PhysicianDao physicianDao;

	public Physician currentPhysician() {
		String account = CustomUserDetailsService.currentUserDetails()
				.getUsername();
		Physician physician = physicianDao.getPhysicianByAccount(account);
		return physician;
	}
}
