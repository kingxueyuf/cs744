package com.medical_staff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.CustomSpringUser;
import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;
import com.physician.service.PhysicianService;

@Controller
public class MedicalStaffController {
	@Autowired
	private MedicalStaffService msService;
	@Autowired
	private PhysicianService physicianService;
	
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
	
	@RequestMapping(value = "/medicalstaff/admin/add", method = RequestMethod.POST)
	public @ResponseBody String addMedicalStaffFromAdmin(
			@RequestBody MedicalStaff ms) {
		Physician physician = physicianService.getPhysicianBySSN(ms.getPhysician_ssn());
		ms.setPhysician_id(physician.getPhysician_id());
		ms.setPhysician_name(physician.getPhysician_name());
		return msService.save(ms);
	}
	
	@RequestMapping(value = "/medicalstaff/admin/delete", method = RequestMethod.POST)
	public @ResponseBody String deleteMedicalStaffFromAdmin(
			@RequestParam(value = "msid", required = true) int msid) {
		return msService.delete(msid);
	}
	
	@RequestMapping(value = "/medicalstaff/admin/edit", method = RequestMethod.POST)
	public @ResponseBody String editMedicalStaffFromAdmin(
			@RequestBody MedicalStaff ms) {
		return msService.update(ms);
	}
}
