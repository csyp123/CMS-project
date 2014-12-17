package com.synnex.cms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		if (sessionFactory.getCurrentSession()==null) {
			return sessionFactory.openSession();
		}
		return sessionFactory.getCurrentSession();
	}

}
