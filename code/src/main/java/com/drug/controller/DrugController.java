package com.drug.controller;

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

import com.drug.data.Drug;
import com.drug.service.DrugService;
import com.emr.data.Emr;

@Controller
public class DrugController {

	@Autowired
	DrugService drugService;
	
	@RequestMapping(value = "/emr/searchWithInput", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Drug> searchWithInput(
			@RequestParam(value = "drugInput", required = true) String input) {
		List<Drug> list = drugService.searchWithInput(input);
		return list;
	}
}
