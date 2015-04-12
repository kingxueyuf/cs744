package com.patient_physician_relation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.constant.ConstantValue;
import com.medical_staff.service.MedicalStaffService;
import com.patient_physician_relation.dao.PatientPhysicianRelationDao;
import com.patient_physician_relation.data.RelationPhysicianPatient;
import com.physician.service.PhysicianService;

@Service
public class PatientPhysicianRelationService implements
		IPatientPhysicianRelationService {

	@Autowired
	PhysicianService pService;
	@Autowired
	MedicalStaffService msService;
	@Autowired
	PatientPhysicianRelationDao ppRelationDao;

	Physician currentPhysician;

	public List<RelationPhysicianPatient> findPrimaryCaraPatient() {
		// TODO Auto-generated method stub
		if (CustomUserDetailsService.isPhysician()) {
			List<RelationPhysicianPatient> primaryCarePatients = ppRelationDao
					.findPrimaryCareRelation(CustomUserDetailsService
							.currentUserDetails().getUserId());
			return primaryCarePatients;
		} else if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician p = pService.getPhysicianById(ms.getPhysician_id());
			List<RelationPhysicianPatient> primaryCarePatients = ppRelationDao
					.findPrimaryCareRelation(p.getPhysicianId());
			return primaryCarePatients;
		}
		return null;
	}

	@Override
	public List<RelationPhysicianPatient> findTemporaryCaraPatient() {
		// TODO Auto-generated method stub
		if (CustomUserDetailsService.isPhysician()) {
			List<RelationPhysicianPatient> temporaryCarePatients = ppRelationDao
					.findTemporaryCareRelation(CustomUserDetailsService
							.currentUserDetails().getUserId());
			return temporaryCarePatients;
		} else if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician p = pService.getPhysicianById(ms.getPhysician_id());
			List<RelationPhysicianPatient> temporaryCarePatients = ppRelationDao
					.findTemporaryCareRelation(p.getPhysicianId());
			return temporaryCarePatients;
		}
		return null;
	}

	@Override
	public List<RelationPhysicianPatient> findTemporaryCaraByPatientId(
			int patient_id) {
		// TODO Auto-generated method stub
		List<RelationPhysicianPatient> temporaryCarePatients = ppRelationDao
				.findTemporaryCareByPatientId(patient_id);
		return temporaryCarePatients;
	}

	public List<RelationPhysicianPatient> findPhysicianCanMakeAppointment(
			int patient_id) {
		// TODO Auto-generated method stub
		List<RelationPhysicianPatient> list = ppRelationDao.findAllByPatientId(patient_id);
		return list;
	}

}
