package com.webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.domain.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeDesc(String ticketId);
}
