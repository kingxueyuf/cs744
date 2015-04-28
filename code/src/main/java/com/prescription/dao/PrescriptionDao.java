package com.prescription.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prescription.data.Prescription;

@Repository
public class PrescriptionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Prescription> getByTranscriptionId(int transcriptionId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Prescription where transcription_id="
						+ transcriptionId);
		Transaction transaction = session.beginTransaction();
		List<Prescription> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public String save(Prescription p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		int pId = (Integer) session.save(p); // if you want to save the id to
												// some variable
		session.getTransaction().commit();
		session.close();
		return pId + "";
	}

	public Prescription getByPrescriptionId(int prescriptionId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Prescription where prescription_id="
						+ prescriptionId);
		Transaction transaction = session.beginTransaction();
		List<Prescription> list = q.list();
		transaction.commit();
		session.close();
		return (list.size() == 0) ? null : list.remove(0);
	}

	public List<Prescription> toPharmacy(String physician_ssn,
			String patient_ssn, String create_date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Prescription where patient_ssn='"
				+ patient_ssn + "' and physician_ssn='" + physician_ssn
				+ "' and create_date='" + create_date + "'");
		Transaction transaction = session.beginTransaction();
		List<Prescription> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

}
