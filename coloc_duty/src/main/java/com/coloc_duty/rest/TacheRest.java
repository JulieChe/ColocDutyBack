package com.coloc_duty.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.repository.TacheRepository;

@RestController
@CrossOrigin("*")
public class TacheRest {

	
	@Autowired
	private TacheRepository tacheRepo;
	
	
	
}
