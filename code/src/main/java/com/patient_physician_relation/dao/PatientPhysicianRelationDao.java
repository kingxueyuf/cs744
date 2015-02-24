package com.patient_physician_relation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.Physician;
import com.patient_physician_relation.data.RelationPhysicianPatient;

@Repository
public class PatientPhysicianRelationDao implements
		IPatientPhysicianRelationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RelationPhysicianPatient> find() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RelationPhysicianPatient");
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

}
