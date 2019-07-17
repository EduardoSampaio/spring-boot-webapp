package com.webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
