package com.webapp.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.webapp.enums.StatusEnum;

@Document
public class ChangeStatus {
	
	@Id
	private String id;	
	@DBRef
	private Ticket ticket;
	@DBRef
	private User userChange;
	private Date dateChange;
	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUserChange() {
		return userChange;
	}

	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}

	public Date getDateChange() {
		return dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Date getDateChangeStatus() {
		return dateChange;
	}

	public void setDateChangeStatus(Date dateChange) {
		this.dateChange = dateChange;
	}

	
	
}
