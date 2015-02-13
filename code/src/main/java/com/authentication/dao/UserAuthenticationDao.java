package com.authentication.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.DbUser;
import com.client.data.Client;

@Repository
public class UserAuthenticationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<DbUser> listUser() {
		Session session = sessionFactory.openSession();
		List<DbUser> list;
		try {
			list = session.createQuery("from DbUser").list();
		} finally {
			session.close();
		}
		return list;
	}

	public String addUser(DbUser user) {
		Session session = sessionFactory.openSession();
		String uid = (String) session.save(user);
		session.close();
		return uid;
	}

	public Client findClientUser(String account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("from Client where account ='"+account+"'");
		List<Client> l = q.list();
		transaction.commit();
		session.close();
		if(l.size()>0){
			return l.remove(0);
		}
		else{
			return null;
		}
	}

}
