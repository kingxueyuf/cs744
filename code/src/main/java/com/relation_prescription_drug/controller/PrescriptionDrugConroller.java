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
	public @ResponseBody List<PrescriptionDrugRelation> getPrescriptionDrug(
			@RequestParam(value = "prescription_id", required = true) int prescriptionId) {
		return pdService.getByPrescriptionId(prescriptionId);
	}

	@RequestMapping(value = "/drug/add", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody String add(
			@RequestParam(value = "medicalName", required = true) String medicalName,
			@RequestParam(value = "commercialName", required = true) String commercialName,
			@RequestParam(value = "dose", required = true) String dose,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "prescriptionId", required = true) int prescriptionId,
			@RequestParam(value = "drugId", required = true) int drugId,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "refill", required = true) String refill) {

		PrescriptionDrugRelation pdr = new PrescriptionDrugRelation();
		pdr.setDrug_id(drugId);
		pdr.setDrug_name_commercial(commercialName);
		pdr.setDrug_name_medical(medicalName);
		pdr.setDrug_dose(dose);
		pdr.setDrug_price(price);
		pdr.setPrescription_id(prescriptionId);
		pdr.setAmount(amount);
		pdr.setRefill(refill);
		pdService.save(pdr);
		return "success";
	}
}
