package com.jspiders.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc1.pojo.UserPOJO;
import com.jspiders.springmvc1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserPOJO add(String name, String email, String username, String password) {
	
	      UserPOJO user = repository.add(name, email, username, password);
	      return user;
	}
	public UserPOJO login(String username, String password) {
		UserPOJO user = repository.login(username, password);
		return user;
	}
	
	public UserPOJO search(int id) {
		UserPOJO user = repository.search(id);
		return user;
	}

	public List<UserPOJO> searchAll() {
		List<UserPOJO> users = repository.searchAll();
		return users;
	}
	
	public UserPOJO ReturnBook(int id, String email, String username, String password) {
		Object user = repository.findByID(id);
	//	((Object) repository).save(user);
		return (UserPOJO) user;
	}

}
