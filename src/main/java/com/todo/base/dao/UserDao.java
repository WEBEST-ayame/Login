package com.todo.base.dao;

import javax.persistence.EntityManager;

import com.todo.base.entity.UserDetailEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
	EntityManager em;

	
	public void registUser(UserDetailEntity entity) {
		
		em.persist(entity);
	}
	

}
