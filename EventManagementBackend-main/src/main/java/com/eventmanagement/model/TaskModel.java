package com.eventmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASK")
public class TaskModel {
	@Id
	private String tid;
	private String description;
	private String status;
	private String task_type;
	@ManyToOne
	@JoinColumn(name = "Assigned_Staff")
	private UserModel usermodel;
	@ManyToOne
	@JoinColumn(name = "Event_id")
	private EventModel eventmodel;
	private String vendor_name;
	private String vendor_contact;
	private long ebudget;
	
	public TaskModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

	public UserModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(UserModel usermodel) {
		this.usermodel = usermodel;
	}

	public EventModel getEventmodel() {
		return eventmodel;
	}

	public void setEventmodel(EventModel eventmodel) {
		this.eventmodel = eventmodel;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_contact() {
		return vendor_contact;
	}

	public void setVendor_contact(String vendor_contact) {
		this.vendor_contact = vendor_contact;
	}

	public long getEbudget() {
		return ebudget;
	}

	public void setEbudget(long ebudget) {
		this.ebudget = ebudget;
	}
	
}
