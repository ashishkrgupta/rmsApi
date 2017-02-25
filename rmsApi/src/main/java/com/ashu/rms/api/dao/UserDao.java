package com.ashu.rms.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashu.rms.api.common.model.User;

@Component
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public User getUserByUsernameAndPassword(String username, String password){
		User user = null;
		Session session = sessionFactory.openSession();
		//session.get
		Criteria userCr = session.createCriteria(User.class);
		userCr.add(Restrictions.eq("userId", username));
		userCr.add(Restrictions.eq("password", password));
		List<User> users = userCr.list();
		if (users.size() == 1){
			user = users.get(0);
		}
		return user;
	}
}
