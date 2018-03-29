package com.lucas.helpdesk.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.lucas.helpdesk.api.entity.ChangeStatus;
import com.lucas.helpdesk.api.entity.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);
	
	Ticket findById(String id);
	
	void delete(String id);
	
	Page<Ticket> listTicket(int page, int count);
	
	ChangeStatus createChanceStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String id);
	
	Page<Ticket> findByCurrentUser(int page, int count, String userId);
	
}
