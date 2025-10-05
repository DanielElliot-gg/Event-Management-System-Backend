package com.eventmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.dto.client_task;
import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;
import com.eventmanagement.model.UserModel;
import com.eventmanagement.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
@Autowired
ClientService client;
	// Event Actions:
	@GetMapping("/ShowAllEvent")
	public List<EventModel> ShowAllEvent(@RequestParam int id) {
		return client.ShowAllEvent(id);
	}
	@PostMapping("/Addevent")
	public List<EventModel> Addevent(@RequestBody List<EventModel> details) {
		return client.Addevent(details);
		 
	}
	@PutMapping("/EventStatus")
	public String EventStatus(@RequestParam String status, @RequestParam int id){
		  Integer result = client.EventStatus(status, id);
		  if (result==null || result==0) {
				return "Status Cant be Updated";
			}
			else {
				return "Status updated";
			}
	}
	// Login And Register:
	@GetMapping("/login")
	public ArrayList<Object> login(@RequestParam String username, @RequestParam String password) {
		ArrayList<Object> result = client.login(username,password);
		if (result==null) {
			return null;
		}
		else {
			return result;
		}
	}
	@PostMapping("/register")
	public String register(@RequestBody List<UserModel> user) {
		client.register(user);
		return "Registered Successfully!!";
	}
	// Task Actions 
	@PostMapping("/CreateTasks")
	public String CreateTasks(@RequestBody client_task clienttask) {
		ResponseEntity<String> result  = client.CreateTasks(clienttask);
		if(result.getBody().equals("1")) {			
			return "Task Added Successfully";
		}
		else {
			return "Failed to add the task";
		}
	}
	@GetMapping("/showtasks")
	public List<TaskModel> showtasks(@RequestParam int eid) {
		return client.showtasks(eid);
	}
	
	
	@GetMapping("/listoftasks")
	public ArrayList<String> listalltasks(@RequestParam int eid){
		return client.listalltasks(eid);
	}
}
