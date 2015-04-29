package com.drug.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.data.Drug;
import com.drug.data.DrugFromPharmacy;
import com.drug.service.DrugService;
import com.emr.data.Emr;
import com.patient.data.Patient;

@Controller
public class DrugController {

	@Autowired
	DrugService drugService;
	
	@RequestMapping(value = "/drug/searchWithInput", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Drug> searchWithInput(
			@RequestParam(value = "drugInput", required = true) String input) {
		List<Drug> list = drugService.searchWithInput(input);
		return list;
	}
	
	@RequestMapping(value = "/drug/search", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<DrugFromPharmacy> search(
			@RequestParam(value = "drugInput", required = true) String input,
			@RequestParam(value = "drugNameType", required = true) String nameType) {
		List<DrugFromPharmacy> list = drugService.search(input,nameType);
		return list;
	}
	
	@RequestMapping(value = "/pharmacy/drug/edit", method = RequestMethod.POST)
	public @ResponseBody String edit(@RequestBody DrugFromPharmacy drug) {
		return drugService.update(drug);
		
	}
	
}
