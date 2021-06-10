package com.masterrestful.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterrestful.app.model.User;
import com.masterrestful.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers(){
		return this.repo.findAll();
	}
	
	public User createUser(User user) {
		return repo.save(user);
	}

//	public List<User> createUsers(List<User> users) {
//		return repo.saveAll(users);
//	}

	public Optional<User> getUserById(Long id) {
		return repo.findById(id);
	}
	
	public User updateUserById(Long id, User user) {
		user.setUserid(id);
		return repo.save(user);
	}

	public void deleteUserById(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
		}
	}

	public User getUserByUserName(String username) {
		return repo.findByUsername(username);
	}
}
