package com.relation_prescription_drug.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.relation_prescription_drug.data.PrescriptionDrugRelation;
import com.relation_prescription_drug.service.PrescriptionDrugService;


@Controller
public class PrescriptionDrugConroller {
	
	@Autowired
	PrescriptionDrugService pdService;
	
	@RequestMapping(value = "/prescription/item", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<PrescriptionDrugRelation> getPrescriptionDrug(@RequestParam(value = "prescription_id", required = true) int prescriptionId) {
		return pdService.getByPrescriptionId(prescriptionId);
	}
}
