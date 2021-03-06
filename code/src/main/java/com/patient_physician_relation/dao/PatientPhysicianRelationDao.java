package com.patient_physician_relation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.Physician;
import com.constant.ConstantValue;
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

	@Override
	public List<RelationPhysicianPatient> findTemporaryCareByPatientId(
			int patient_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from RelationPhysicianPatient where patient_id = "
						+ patient_id
						+ " and relation_type = '"
						+ ConstantValue.TEMPORARY_CARE_RELATION + "'");
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<RelationPhysicianPatient> findPrimaryCareRelation(
			int physicianId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from RelationPhysicianPatient where relation_type='"
						+ ConstantValue.PRIMARY_CARE_RELATION
						+ "' and physician_id=" + physicianId);
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<RelationPhysicianPatient> findTemporaryCareRelation(
			int physicianId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from RelationPhysicianPatient where relation_type='"
						+ ConstantValue.TEMPORARY_CARE_RELATION
						+ "' and physician_id=" + physicianId);
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<RelationPhysicianPatient> findAllByPatientId(int patient_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from RelationPhysicianPatient where patient_id="
						+ patient_id);
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public String save(RelationPhysicianPatient rpp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(rpp);
		session.getTransaction().commit();
		session.close();
		return "success";
	}

	public RelationPhysicianPatient findPrimaryCaraPatientById(int patient_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from RelationPhysicianPatient where patient_id="
						+ patient_id + " and relation_type='"
						+ ConstantValue.PRIMARY_CARE_RELATION + "'");
		Transaction transaction = session.beginTransaction();
		List<RelationPhysicianPatient> list = q.list();
		transaction.commit();
		session.close();
		return (list.size() > 0) ? list.get(0) : null;
	}

}
