package com.physician.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.Physician;

@Repository
public class PhysicianDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Physician getPhysicianByAccount(String account) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Physician where account = '"
				+ account + "'");
		Transaction transaction = session.beginTransaction();
		List<Physician> list = q.list();
		transaction.commit();
		session.close();
		Physician p = (Physician) ((list.size() != 0) ? list.remove(0) : null);
		return p;
	}

	public List<Physician> serachWithInput(String input) {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Physician where physicianName like '"
						+ input + "%'");
		Transaction transaction = session.beginTransaction();
		List<Physician> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public Physician getPhysicianById(int physicianId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Physician where physician_id = "
				+ physicianId);
		Transaction transaction = session.beginTransaction();
		List<Physician> list = q.list();
		transaction.commit();
		session.close();
		Physician p = (Physician) ((list.size() != 0) ? list.remove(0) : null);
		return p;
	}

	public String save(Physician physician) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(physician);
		session.getTransaction().commit();
		session.close();
		return "success";
	}

	public String delete(int physicianId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete Physician where physician_id = "
				+ physicianId);
		q.executeUpdate();
		session.close();
		return "success";
	}

	public Physician getPhysicianBySSN(String ssn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Physician where SSN = '" + ssn
				+ "'");
		List<Physician> list = q.list();
		session.close();
		Physician p = (Physician) ((list.size() != 0) ? list.remove(0) : null);
		return p;
	}

}
