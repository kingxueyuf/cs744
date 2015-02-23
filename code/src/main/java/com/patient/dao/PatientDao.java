package com.patient.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.Physician;
import com.patient.data.Patient;

@Repository
public class PatientDao implements IPatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> find() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Patient");
		Transaction transaction = session.beginTransaction();
		List<Patient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

}
