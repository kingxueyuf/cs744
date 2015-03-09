package com.relation_transcription_surgery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.relation_transcription_surgery.data.TranscriptionSurgeryRelation;
import com.relation_transcription_surgery.service.TranscriptionSurgeryRelationService;

@Controller
public class TranscriptionSurgeryRelationController {
	@Autowired
	TranscriptionSurgeryRelationService tsrService;
	
	@RequestMapping(value = "/relation_transcription_surgery/getSurgery", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<TranscriptionSurgeryRelation> getSurgeryListByTranscriptionId(@RequestParam(value = "transcription_id", required = true) int transcriptionId) {
		return tsrService.getByTranscriptionId(transcriptionId);
	}
}
