package com.diagnostic_test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diagnostic_test.data.DiagnosticTest;
import com.surgery.data.Surgery;

@Repository
public class DiagnosticTestDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<DiagnosticTest> serachWithInput(String input) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from DiagnosticTest where diagnostic_test_name like '"
						+ input + "%'");
		Transaction transaction = session.beginTransaction();
		List<DiagnosticTest> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public DiagnosticTest getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from DiagnosticTest where diagnostic_test_id = "
						+ id);
		Transaction transaction = session.beginTransaction();
		List<DiagnosticTest> list = q.list();
		transaction.commit();
		session.close();
		return (DiagnosticTest) ((list.size() != 0) ? list.remove(0) : null);
	}

}
