package com.digit.aadharmodel;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;


import com.digit.hibernate.aadhar.AadharDetails;

public class HibernateManager {
	private Session session;

	public HibernateManager() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();

		System.out.println("Connected to Pf...");

	}
	public boolean saveObject(AadharDetails a) {

		Transaction trn = session.beginTransaction();

		Serializable save = session.save(a);

		trn.commit();

		System.out.println("Object Saved!");
		if(save==null) {
		return false;
		}
		return true;

	}
	public List readAll() {

		Transaction trn = session.beginTransaction();
		Query q = session.createQuery("From AadharDetails");
		List li = q.list();
		Iterator itr = li.iterator();
		return li;
	
	}
	public void update(int ID,String changecolumn,String newValue) {
		Transaction trn = session.beginTransaction();
		AadharDetails a = (AadharDetails)session.get(AadharDetails.class,ID);
	     switch(changecolumn) {
	     case "Name":{
	    	 a.setName(newValue);
	    	 break;
	     }
	     case "DOB":{
	    	 a.setDOB(newValue);
	    	 break;
	     }
	    	 default:
	    	 
	     }

	     session.update(a);
		System.out.println("Update Success");
		trn.commit();
		
		}
	public void delete(int ID) {
		Transaction trn = session.beginTransaction();
		AadharDetails a = (AadharDetails)session.get(AadharDetails.class,ID);
		session.delete(a);
		System.out.println("Delete Success");
		trn.commit();
		
	}
	public AadharDetails readSpecific(int ID) {
		session.beginTransaction();
		AadharDetails a = (AadharDetails)session.get(AadharDetails.class,ID);
		
		return a;
	}


}
