package com.drug.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drug.data.Drug;
import com.drug.data.DrugFromPharmacy;
import com.emr.data.Emr;

@Repository
public class DrugDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Drug> searchWithInput(String input) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Drug where drug_name like '"
				+ input + "%'");
		Transaction transaction = session.beginTransaction();
		List<Drug> list = q.list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<DrugFromPharmacy> search(String input, String nameType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		if (nameType.equals("medical")) {
			Query q = session
					.createQuery("from DrugFromPharmacy where drug_name_medical like '"
							+ input + "%'");
			Transaction transaction = session.beginTransaction();
			List<DrugFromPharmacy> list = q.list();
			transaction.commit();
			session.close();
			return list;
		} else {
			Query q = session
					.createQuery("from DrugFromPharmacy where drug_name_commercial like '"
							+ input + "%'");
			Transaction transaction = session.beginTransaction();
			List<DrugFromPharmacy> list = q.list();
			transaction.commit();
			session.close();
			return list;
		}
	}

	public List<DrugFromPharmacy> searchForMedicalStaff(String input,
			String nameType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		if (nameType.equals("medical")) {
			Query q = session
					.createQuery("from DrugFromPharmacy where drug_name_medical like '"
							+ input + "%' and drug_lv ='0'");
			Transaction transaction = session.beginTransaction();
			List<DrugFromPharmacy> list = q.list();
			transaction.commit();
			session.close();
			return list;
		} else {
			Query q = session
					.createQuery("from DrugFromPharmacy where drug_name_commercial like '"
							+ input + "%' and drug_lv ='0'");
			Transaction transaction = session.beginTransaction();
			List<DrugFromPharmacy> list = q.list();
			transaction.commit();
			session.close();
			return list;
		}
	}

	public String update(DrugFromPharmacy drug) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from DrugFromPharmacy where drug_unique_id = '"
						+ drug.getDrug_unique_id() + "'");
		List<DrugFromPharmacy> list = q.list();
		DrugFromPharmacy item = (list.size() > 0) ? list.get(0) : null;
		drug.setDrug_id(item.getDrug_id());
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(drug);
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
