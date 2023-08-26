package com.jspiders.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	public AdminPOJO add(String name, String email, String username, String password) {
	
	      AdminPOJO admin = repository.add(name, email, username, password);
	      return admin;
	}
	public AdminPOJO login(String username, String password) {
		AdminPOJO admin = repository.login(username, password);
		return admin;
	}
	
	public AdminPOJO search(int id) {
		AdminPOJO admin = repository.search(id);
		return admin;
	}

	public List<AdminPOJO> searchAll() {
		List<AdminPOJO> admins = repository.searchAll();
		return admins;
	}
	public AdminPOJO remove(int id) {
		AdminPOJO admin = repository.remove(id);
		return admin;
	}

	public AdminPOJO update(int id, String name, String email, String username, String password) {
		AdminPOJO admin = repository.update(id, name, email, username, password);
		return admin;
	}

}