package com.webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webapp.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
