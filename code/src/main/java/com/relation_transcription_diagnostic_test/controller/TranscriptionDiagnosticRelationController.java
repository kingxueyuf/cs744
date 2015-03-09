package com.relation_transcription_diagnostic_test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.relation_transcription_diagnostic_test.data.TranscriptionDiagnosticRelation;
import com.relation_transcription_diagnostic_test.service.TranscriptionDiagnosticRelationService;

@Controller
public class TranscriptionDiagnosticRelationController {

	@Autowired
	TranscriptionDiagnosticRelationService tdrService;

	@RequestMapping(value = "/relation_transcription_diagnostic_test/getDiagnostic", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<TranscriptionDiagnosticRelation> getDiagnosticListByTranscriptionId(
			@RequestParam(value = "transcription_id", required = true) int transcriptionId) {
		return tdrService.getByTranscriptionId(transcriptionId);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody void upload() {

	}

}
