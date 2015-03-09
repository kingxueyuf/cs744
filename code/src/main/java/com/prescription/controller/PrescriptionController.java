package com.prescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prescription.data.Prescription;
import com.prescription.service.PrescriptionService;

@Controller
public class PrescriptionController {
	
	@Autowired
	PrescriptionService pService;
	
	@RequestMapping(value = "/prescription/list", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Prescription> list(@RequestParam(value = "transcription_id", required = true) int transcriptionId) {
		return pService.getByTranscriptionId(transcriptionId);
	}
}
