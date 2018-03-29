package com.lucas.helpdesk.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.helpdesk.api.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
	
	Optional<User> findById(String id);
	
}
