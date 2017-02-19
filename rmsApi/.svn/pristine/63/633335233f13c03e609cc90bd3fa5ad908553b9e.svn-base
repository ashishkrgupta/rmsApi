package com.ashu.rms.api.dao;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashu.rms.api.common.model.CoreEntity;


@Component
public class CommonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(CoreEntity entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		session.close();
	}
	
	public Object getById(int id, Class<? extends CoreEntity> entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object o = session.get(entity, id);
		tx.commit();
		session.close();
		return o;
	}

	@SuppressWarnings("unchecked")
	public List<?> list(Class<? extends CoreEntity> clazz) {
		Session session = this.sessionFactory.openSession();
		Table table = clazz.getAnnotation(Table.class);
		List<? extends CoreEntity> personList = session.createQuery(" from " + table.name()).list();
		session.close();
		return personList;
	}

}
