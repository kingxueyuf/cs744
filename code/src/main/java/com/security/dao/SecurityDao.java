package com.security.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.data.Security;

@Repository
public class SecurityDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Security getById(Integer userId, String userType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println("userId = " + userId);
		Query q = session.createQuery("from Security where user_id = " + userId
				+ " and user_title ='" + userType + "'");
		Transaction transaction = session.beginTransaction();
		List<Security> list = q.list();
		transaction.commit();
		session.close();
		Security security = (Security) ((list.size() != 0) ? list.remove(0)
				: null);
		return security;
	}

	public void save(Security s) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

}
