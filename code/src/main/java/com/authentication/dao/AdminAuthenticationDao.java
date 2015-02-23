package com.authentication.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.authentication.data.Physician;

@Repository
public class AdminAuthenticationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// TODO
	public void addUser(Physician user){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("");
	}
	
	public void deleteUser(Physician user){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.delete("from Physician where physician_id ='" + user.id +"'");
	}
	
}
