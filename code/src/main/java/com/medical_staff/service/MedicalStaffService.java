package com.medical_staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.MedicalStaff;
import com.medical_staff.dao.MedicalStaffDao;

@Service
public class MedicalStaffService {
	@Autowired
	MedicalStaffDao msDao;

	public List<MedicalStaff> list() {
		return msDao.list();
	}

	public MedicalStaff getMedicalstaffById(int id) {
		return msDao.getById(id);
	}

	public List<MedicalStaff> getByPhysicianId(int id) {
		return msDao.getByPhysicianId(id);
	}

	public String save(MedicalStaff ms) {
		// TODO Auto-generated method stub
		return msDao.save(ms);
	}

	public String delete(int msid) {
		// TODO Auto-generated method stub
		return msDao.delete(msid);
	}

	public String update(MedicalStaff ms) {
		// TODO Auto-generated method stub
		return msDao.update(ms);
	}
}
