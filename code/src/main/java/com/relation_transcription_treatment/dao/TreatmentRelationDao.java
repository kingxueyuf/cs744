package com.relation_transcription_treatment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relation_transcription_treatment.data.TreatmentRelation;

@Repository
public class TreatmentRelationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void add(TreatmentRelation tr) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(tr);
		session.getTransaction().commit();
		session.close();
	}

	public List<TreatmentRelation> getByTranscriptionId(int transcriptionId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from TreatmentRelation where transcription_id ="
						+ transcriptionId);
		Transaction transaction = session.beginTransaction();
		List<TreatmentRelation> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}
}
