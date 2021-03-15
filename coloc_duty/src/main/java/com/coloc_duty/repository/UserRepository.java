package com.coloc_duty.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.User;

public interface UserRepository  extends CrudRepository<User,Long>{
	
	public Optional<User> findByLoginAndPassword(String login, String password);

}
