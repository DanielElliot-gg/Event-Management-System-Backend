package com.eventmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eventmanagement.dto.client_task;
import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;
import com.eventmanagement.model.UserModel;
import com.eventmanagement.repository.EventRepo;
import com.eventmanagement.repository.TaskRepo;
import com.eventmanagement.repository.UserRepo;

@Service
public class ClientService {
@Autowired
EventRepo event;
@Autowired
UserRepo user;
@Autowired 
TaskRepo taskrepo;

	// Event Table
	public List<EventModel> ShowAllEvent(int cid) {
		return event.findalleventbycid(cid);

	}
	public List<EventModel> Addevent(List<EventModel> details) { 
		return event.saveAll(details);
	}
	
	public Integer EventStatus(String status, int id) {
		return event.EventStatus(status ,id);
	}
	
	// User table
	public ArrayList<Object> login(String username, String password) {
		return user.loginbyid(username,password);
	}
	public List<UserModel> register(List<UserModel> newuser) {
		return user.saveAll(newuser);
	}
	
	// Task Table
	public ResponseEntity<String> CreateTasks(client_task ct) {
			EventModel eventmodel  = event.findById(ct.getEid()).orElseThrow(()->new RuntimeException("Event not found"));
			ArrayList<String> tasks = listalltasks(eventmodel.getEid());
			int maxNum = 0;
			for(String tid: tasks) {
				String[] parts =  tid.split("_");
				if(parts.length==3) {
					try {
						int num = Integer.parseInt(parts[2]);
						if(num>maxNum) {
							maxNum = num;
						}
					}catch(NumberFormatException e) {
						
					}
				}
			} 
			String task_title = ct.getTask_name();
			String task_type = ct.getTask_type();
			long evnt_budget = ct.getEbudget();
			TaskModel task = new TaskModel();
			task.setTid("T_"+eventmodel.getEid()+"_"+(maxNum+1));
			task.setEventmodel(eventmodel);
			task.setDescription(task_title);
			task.setTask_type(task_type);
			task.setEbudget(evnt_budget);
			UserModel users = user.findById(0)
			        .orElseThrow(() -> new RuntimeException("User not found"));
			task.setUsermodel(users);
			taskrepo.save(task);
	
		return ResponseEntity.ok("1");
	}
	 
	
	public List<TaskModel> showtasks(int eid) {
		 return taskrepo.findbyeid(eid);
	}
	
	public ArrayList<String> listalltasks(int eid) {
		return taskrepo.findlisttask(eid);
	}
	
	
}
