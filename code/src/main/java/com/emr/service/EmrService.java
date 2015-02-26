package com.emr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.dao.EmrDao;
import com.emr.data.Emr;

@Service
public class EmrService {

	@Autowired
	EmrDao eDao;

	public Emr getEmrByPatientId(int patientId) {
		// TODO Auto-generated method stub
		Emr emr = eDao.findEmrByPatientId(patientId);
		return emr;
	}
	
	public void createNewEmr(Emr emr){
		eDao.insertNewEmr(emr);
	}
	
	
}
