package com.patient_physician_relation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.Physician;
import com.constant.ConstantValue;
import com.patient_physician_relation.dao.PatientPhysicianRelationDao;
import com.patient_physician_relation.data.RelationPhysicianPatient;
import com.physician.service.PhysicianService;

@Service
public class PatientPhysicianRelationService implements
		IPatientPhysicianRelationService {

	@Autowired
	PhysicianService pService;
	@Autowired
	PatientPhysicianRelationDao ppRelationDao;

	Physician currentPhysician;

	public List<RelationPhysicianPatient> findPrimaryCaraPatient() {
		// TODO Auto-generated method stub
		List<RelationPhysicianPatient> patients = ppRelationDao.find();
		List<RelationPhysicianPatient> primaryCarePatients = new ArrayList<RelationPhysicianPatient>();
		for (RelationPhysicianPatient p : patients) {
			if (p.getPhysician_id() == getCurrentPhysician().getPhysicianId()
					&& p.getRelation_type().equals(
							ConstantValue.PRIMARY_CARE_RELATION)) {
				primaryCarePatients.add(p);
			}
		}
		return primaryCarePatients;
	}

	@Override
	public List<RelationPhysicianPatient> findTemporaryCaraPatient() {
		// TODO Auto-generated method stub
		List<RelationPhysicianPatient> patients = ppRelationDao.find();
		List<RelationPhysicianPatient> temporaryCarePatients = new ArrayList<RelationPhysicianPatient>();
		for (RelationPhysicianPatient p : patients) {

			if (p.getPhysician_id() == getCurrentPhysician().getPhysicianId()
					&& p.getRelation_type().equals(
							ConstantValue.TEMPORARY_CARE_RELATION)) {
				temporaryCarePatients.add(p);
			}
		}
		return temporaryCarePatients;
	}

	private Physician getCurrentPhysician() {
		if (currentPhysician == null) {
			currentPhysician = pService.currentPhysician();
		}
		return currentPhysician;
	}

}
