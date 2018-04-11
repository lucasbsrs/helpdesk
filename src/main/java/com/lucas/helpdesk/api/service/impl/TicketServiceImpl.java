package com.lucas.helpdesk.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.lucas.helpdesk.api.entity.ChangeStatus;
import com.lucas.helpdesk.api.entity.Ticket;
import com.lucas.helpdesk.api.repository.ChangeStatusRepository;
import com.lucas.helpdesk.api.repository.TicketRepository;
import com.lucas.helpdesk.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;
	
	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Optional<Ticket> findById(String id) {
		return this.ticketRepository.findById(id);
	}

	@Override
	public void delete(String id) {
		this.ticketRepository.deleteById(id);		
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public ChangeStatus createChanceStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String id) {
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeDesc(id);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority, String userId) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findByNumber(number,pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParametersAndAssingnedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		Pageable pages = new QPageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignerUserIdOrderByDateDesc(title, status, priority, pages);
	}

}
