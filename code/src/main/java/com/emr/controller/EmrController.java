package com.emr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emr.data.Emr;
import com.emr.service.EmrService;

@Controller
public class EmrController {
	@Autowired
	EmrService eService;

	@RequestMapping(value = "/emr/check", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody Map<String, String> patient(
			@RequestParam(value = "patientId", required = true) int patientId) {
		HashMap<String, String> map = new HashMap<String, String>();
		Emr emr = eService.getEmrByPatientId(patientId);
		if (emr != null) {
			map.put("hasEmr", "true");
			map.put("emrId", emr.getEmr_id() + "");
		} else {
			map.put("hasEmr", "false");
		}
		return map;
	}
}
