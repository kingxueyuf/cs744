package com.medical_staff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.CustomSpringUser;
import com.authentication.data.MedicalStaff;
import com.authentication.service.CustomUserDetailsService;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;

@Controller
public class MedicalStaffController {
	@Autowired
	private MedicalStaffService msService;

	@RequestMapping(value = "/relation/physicianAndMedicalStaff", method = RequestMethod.GET)
	public @ResponseBody List<MedicalStaff> get() {
		CustomSpringUser cs = CustomUserDetailsService.currentUserDetails();
		if (CustomUserDetailsService.isMedicalStaff()) {
			List<MedicalStaff> list = new ArrayList<MedicalStaff>();
			list.add(msService.getMedicalstaffById(cs.getUserId()));
			return list;
		} else {
			// is Physician
			return msService.getByPhysicianId(cs.getUserId());
		}
	}
}
