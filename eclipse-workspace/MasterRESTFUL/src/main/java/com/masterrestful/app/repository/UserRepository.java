package com.masterrestful.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masterrestful.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findAll();
	
	public User save(User user);

//	public List<User> saveAll(List<User> users);
	
	public Optional<User> findById(Long id);

	public void deleteById(Long id);
	
	public User findByUsername(String username);
}
