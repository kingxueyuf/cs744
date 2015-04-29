package com.medical_staff.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.MedicalStaff;

@Repository
public class MedicalStaffDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<MedicalStaff> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from MedicalStaff");
		Transaction transaction = session.beginTransaction();
		List<MedicalStaff> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public MedicalStaff getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from MedicalStaff where msid=" + id);
		Transaction transaction = session.beginTransaction();
		List<MedicalStaff> list = q.list();
		transaction.commit();
		session.close();
		return list.remove(0);
	}
	
	public List<MedicalStaff> getByPhysicianId(int id){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from MedicalStaff where physician_id=" + id);
		Transaction transaction = session.beginTransaction();
		List<MedicalStaff> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public String save(MedicalStaff ms) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(ms);
		session.getTransaction().commit();
		session.close();
		return "success";
	}

	public String delete(int msid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete MedicalStaff where msid = "
				+ msid);
		q.executeUpdate();
		session.close();
		return "success";
	}

	public String update(MedicalStaff ms) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(ms);
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
