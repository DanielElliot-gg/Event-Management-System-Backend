package com.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;
import com.eventmanagement.model.UserModel;
import com.eventmanagement.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
@Autowired
StaffService staff;
	
	//Event actions
	@GetMapping("/ShowAllEvent")
	public List<EventModel> staffevents(@RequestParam int id) {
		return staff.ShowAllEvent(id);
	}
	
	 
	
	@PutMapping("/acceptevent")
	public String AcceptEvent(@RequestParam int eid, @RequestParam int sid) {
		return staff.AcceptEvent(eid,sid);
	}
	
	// Task actions
	@GetMapping("/showtasks")
	public List<TaskModel> showtasks(@RequestParam int eid, @RequestParam int sid) {
		return staff.showtasks(eid,sid);
	}
	
	
	
	@PutMapping("/TaskStatus")
	public String TaskStatus(@RequestParam String status, @RequestParam String taskid){
		  Integer result = staff.TaskStatus(status, taskid);
		  if (result==null || result==0) {
				return "Status Cant be Updated";
			}
			else {
				return "Status updated";
			}
	}
	@PutMapping("/updatevendors")
	public String updateVendorDetails(@RequestParam String task_id,@RequestParam String name, @RequestParam String contact) {
		Integer result = staff.updateVendorDetails(task_id,name,contact);
		  if (result==null || result==0) {
				return "Status Cant be Updated";
			}
			else {
				return "Status updated";
			}
		
	}
	
	// login and register
	 
	@PostMapping("/register")
	public String register(@RequestBody List<UserModel> user) {
		staff.register(user);
		return "Registered Successfully!!";
	}
}
