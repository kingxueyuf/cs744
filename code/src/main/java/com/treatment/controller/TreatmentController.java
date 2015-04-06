package com.treatment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.service.CustomUserDetailsService;
import com.treatment.data.Treatment;
import com.treatment.service.TreatmentService;


@Controller
public class TreatmentController {
	@Autowired
	private TreatmentService treatmentService;

	@RequestMapping(value = "/treatment", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Treatment> list() {
		if(CustomUserDetailsService.isMedicalStaff()){
			return treatmentService.getMedicalStaffTreatment();
		}else if(CustomUserDetailsService.isPhysician()){
			return treatmentService.list();
		}
		return null;
	}
}
