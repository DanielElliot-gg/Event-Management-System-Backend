package com.eventmanagement.dto;

public class client_task {
	private String tid;
	private int eid;
	private String task_name;
	private String task_type;
	private long ebudget;
	public client_task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public long getEbudget() {
		return ebudget;
	}
	public void setEbudget(long ebudget) {
		this.ebudget = ebudget;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}
