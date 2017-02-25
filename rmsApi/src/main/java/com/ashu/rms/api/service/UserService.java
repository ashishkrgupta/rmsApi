package com.ashu.rms.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.rms.api.common.model.User;
import com.ashu.rms.api.dao.UserDao;

@Service
public class UserService {

	//@Autowired
	//private CommonDAO commonDao;
	
	@Autowired
	UserDao userDao;

	public User getUser(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}
	
	
}
