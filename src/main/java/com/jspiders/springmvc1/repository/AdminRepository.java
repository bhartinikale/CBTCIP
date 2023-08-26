package com.jspiders.springmvc1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.jspiders.springmvc1.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
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
	
	public AdminPOJO add(String name, String email, String username, String password) {
		openConnection();
		transaction.begin();
		AdminPOJO pojo = new AdminPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	
	public AdminPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from AdminPOJO where username = '" + username + "' and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<AdminPOJO> resultList = query.getResultList();
		for (AdminPOJO admin : resultList) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	public AdminPOJO search(int id) {
		openConnection();
		transaction.begin();
		AdminPOJO admin = manager.find(AdminPOJO.class, id);
		if (admin != null) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<AdminPOJO> searchAll() {
		openConnection();
		transaction.begin();
		jpql = "from AdminPOJO";
		query = manager.createQuery(jpql);
		List<AdminPOJO> admins = query.getResultList();
		transaction.commit();
		closeConnection();
		return admins;
	}

	public AdminPOJO remove(int id) {
		openConnection();
		transaction.begin();
		AdminPOJO admin = manager.find(AdminPOJO.class, id);
		if (admin != null) {
			manager.remove(admin);
		}
		transaction.commit();
		closeConnection();
		return admin;
	}

	public AdminPOJO update(int id, String name, String email, String username, String password) {
		openConnection();
		transaction.begin();
		AdminPOJO admin = manager.find(AdminPOJO.class, id);
		if (admin != null) {
			admin.setName(name);
			admin.setEmail(email);
			admin.setUsername(username);
			admin.setPassword(password);
			manager.persist(admin);
			transaction.commit();
			closeConnection();
			return admin;
		}
		transaction.commit();
		closeConnection();
		return null;
	}




}
