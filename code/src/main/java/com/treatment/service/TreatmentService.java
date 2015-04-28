package com.treatment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treatment.dao.TreatmentDao;
import com.treatment.data.Treatment;
@Service
public class TreatmentService {
	
	@Autowired
	TreatmentDao treatmentDao;
	public List<Treatment> getMedicalStaffTreatment() {
		// TODO Auto-generated method stub
		return treatmentDao.getMedicalStaffTreatment();
	}
	public List<Treatment> list() {
		// TODO Auto-generated method stub
		return treatmentDao.list();
	}
	
	public Treatment getById(int id){
		return treatmentDao.getById(id);
	}

}
