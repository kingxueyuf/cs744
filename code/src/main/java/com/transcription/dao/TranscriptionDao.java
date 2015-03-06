
package com.transcription.dao;
/**
 * @author Jingbo Chu	
 *
 * Mar 4, 2015
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.data.Emr;
import com.transcription.data.Transcription;

@Repository
public class TranscriptionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Transcription> findTranscriptionsByEmrId(int emrId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Transcription where emr_id = "
				+ emrId);
		Transaction transaction = session.beginTransaction();
		List<Transcription> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}
}