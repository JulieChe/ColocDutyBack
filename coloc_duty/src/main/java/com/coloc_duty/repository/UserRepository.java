package com.coloc_duty.repository;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.User;

public interface UserRepository  extends CrudRepository<User,Long>{
	
	

}
