package com.transcription.controller;

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

import com.transcription.data.Transcription;
import com.transcription.service.TranscriptionService;

@Controller
public class TranscriptionController {

	@Autowired
	private TranscriptionService transcriptionService;
	
	
	@RequestMapping(value = "/emr/getTranscription", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Transcription> getTranscriptionList(
			@RequestParam(value = "emrId", required = true) int emrId) {
		List<Transcription> list = transcriptionService.getTranscriptionsByEmrId(emrId);
		return list;
	}
}
