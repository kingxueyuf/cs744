package com.treatment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surgery.data.Surgery;
import com.treatment.data.Treatment;


@Repository
public class TreatmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Treatment> getMedicalStaffTreatment() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Treatment where can_medical_staff = 'yes'");
		Transaction transaction = session.beginTransaction();
		List<Treatment> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<Treatment> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Treatment");
		Transaction transaction = session.beginTransaction();
		List<Treatment> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public Treatment getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Treatment where treatment_id = " + id);
		Transaction transaction = session.beginTransaction();
		List<Treatment> list = q.list();
		transaction.commit();
		session.close();
		return (Treatment) ((list.size() != 0) ? list.remove(0) : null);
	}

}
