package com.patient.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.patient.data.*;

@Repository
public class PatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Patient findPatientByPatientId(int patientId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Patient where patient_id = "
				+ patientId);
		Transaction transaction = session.beginTransaction();
		List<Patient> list = q.list();
		transaction.commit();
		session.close();
		Patient patient = (Patient) ((list.size() != 0) ? list.remove(0) : null);
		return patient;
	}

	public String save(Patient patient) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
		return "success";
	}

	public String delete(int patientId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete Patient where patient_id = "
				+ patientId);
		q.executeUpdate();
		session.close();
		return "success";
	}

	public String update(Patient patient) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(patient);
			tx.commit();
			return "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}