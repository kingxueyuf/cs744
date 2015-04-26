package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.service.CustomUserDetailsService;
import com.security.data.Question;
import com.security.data.Security;
import com.security.service.SecurityService;

@Controller
public class SecurityController {
	@Autowired
	SecurityService sService;

	@RequestMapping(value = "/question/check", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody Security security() {
		Security s = null;
		s = sService.getSecurity();
		if (s == null) {
			s = new Security();
			s.hasQuestion = "no";
		} else {
			s.hasQuestion = "yes";
		}
		return s;
	}

	@RequestMapping(value = "/question/add", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody String add(
			@RequestParam(value = "question1", required = true) String question1,
			@RequestParam(value = "question2", required = true) String question2,
			@RequestParam(value = "question3", required = true) String question3,
			@RequestParam(value = "answer1", required = true) String answer1,
			@RequestParam(value = "answer2", required = true) String answer2,
			@RequestParam(value = "answer3", required = true) String answer3) {
		Security s = new Security();
		s.setAnswer1(answer1);
		s.setAnswer2(answer2);
		s.setAnswer3(answer3);
		s.setQuestion1(question1);
		s.setQuestion2(question2);
		s.setQuestion3(question3);
		s.setUser_id(CustomUserDetailsService.currentUserDetails().getUserId());
		s.setUser_title(CustomUserDetailsService.currentUserDetails()
				.getUserType());
		sService.save(s);
		return "success";
	}
	
	@RequestMapping(value = "/question/questions", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Question> questions() {
		return sService.questions();
	
	}
	
}