package com.lucas.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeDesc(String ticketId);
	
}
