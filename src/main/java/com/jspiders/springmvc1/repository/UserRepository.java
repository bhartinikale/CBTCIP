package com.jspiders.springmvc1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc1.pojo.UserPOJO;

@Repository
public class UserRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("WEJM4MVC");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public UserPOJO add(String name, String email, String username, String password) {
		openConnection();
		transaction.begin();
		UserPOJO pojo = new UserPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	
	public UserPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from UserPOJO where username = '" + username + "' and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<UserPOJO> resultList = query.getResultList();
		for (UserPOJO user : resultList) {
			transaction.commit();
			closeConnection();
			return user;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	public UserPOJO search(int id) {
		openConnection();
		transaction.begin();
		UserPOJO user = manager.find(UserPOJO.class, id);
		if (user != null) {
			transaction.commit();
			closeConnection();
			return user;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<UserPOJO> searchAll() {
		openConnection();
		transaction.begin();
		jpql = "from UserPOJO";
		query = manager.createQuery(jpql);
		List<UserPOJO> users = query.getResultList();
		transaction.commit();
		closeConnection();
		return users;
	}

	public Object findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
