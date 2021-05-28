package com.todo.base.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.base.dao.UserDao;
import com.todo.base.entity.UserDetailEntity;

@Service
@Transactional
public class UserService {

    @Autowired
	UserDao userDao;

	
	public void registUserDetail(UserDetailEntity entity) {
		
		userDao.registUser(entity);
	}

}
