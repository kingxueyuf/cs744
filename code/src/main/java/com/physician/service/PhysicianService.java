package com.physician.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.CustomSpringUser;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.constant.ConstantValue;
import com.physician.dao.PhysicianDao;

@Service
public class PhysicianService {
	@Autowired
	PhysicianDao physicianDao;

	public Physician currentPhysician() {
		CustomSpringUser cs = CustomUserDetailsService.currentUserDetails();
		String account = cs.getAccount();
		System.out.println("current user = " + account);
		Physician physician = physicianDao.getPhysicianByAccount(account);
		return physician;
	}
	public Physician getPhysicianById(int physicianId){
		return physicianDao.getPhysicianById(physicianId);
	}

	public List<Physician> searchWithInput(String input) {
		List<Physician> list = physicianDao.serachWithInput(input);
		return list;
	}
	public String save(Physician physician) {
		// TODO Auto-generated method stub
		return physicianDao.save(physician);
	}
}
