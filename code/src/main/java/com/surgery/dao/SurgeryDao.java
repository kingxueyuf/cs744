package com.surgery.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.data.Security;
import com.surgery.data.Surgery;

@Repository
public class SurgeryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Surgery> serachWithInput(String input) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Surgery where surgery_name like '"
				+ input + "%'");
		Transaction transaction = session.beginTransaction();
		List<Surgery> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public Surgery getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Surgery where surgery_id = " + id);
		Transaction transaction = session.beginTransaction();
		List<Surgery> list = q.list();
		transaction.commit();
		session.close();
		return (Surgery) ((list.size() != 0) ? list.remove(0) : null);
	}

}
