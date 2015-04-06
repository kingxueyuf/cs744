package com.relation_transcription_treatment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.service.CustomUserDetailsService;
import com.relation_transcription_treatment.data.TreatmentRelation;
import com.relation_transcription_treatment.service.TreatmentRelationService;




@Controller
public class TreatmentRelationController {
	@Autowired
	TreatmentRelationService trService;
	
	@RequestMapping(value = "/treatment/add", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody String add(@RequestParam(value = "transcriptionId", required = true) int transcriptionId,
			@RequestParam(value = "treatmentName", required = true) String treatmentName,
			@RequestParam(value = "treatmentId", required = true) int treatmentId) {
		TreatmentRelation tr = new TreatmentRelation();
		tr.setTranscription_id(transcriptionId);
		tr.setTreatment_id(treatmentId);
		tr.setTreatment_name(treatmentName);
		tr.setTreatment_operator_id(CustomUserDetailsService.currentUserDetails().getUserId());
		tr.setTreatment_operator_name(CustomUserDetailsService.currentUserDetails().getName());
		tr.setTreatment_operator_type(CustomUserDetailsService.currentUserDetails().getUserType());
		trService.add(tr);
		return "success";
	}
	
	@RequestMapping(value = "/treatment/get", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<TreatmentRelation> get(@RequestParam(value = "transcriptionId", required = true) int transcriptionId) {
		return trService.getByTranscriptionId(transcriptionId);
	}
}
