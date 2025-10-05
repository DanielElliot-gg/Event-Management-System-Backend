package com.eventmanagement.controller;

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

import com.eventmanagement.dto.planner_task;
import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;
import com.eventmanagement.model.UserModel;
import com.eventmanagement.service.PlannerService;

@RestController
@RequestMapping("/planner")
public class PlannerController {
@Autowired
PlannerService planner;
	
	// events actions 
	@GetMapping("/showallevent")
	public List<EventModel> ShowAllEvent() {
		return planner.ShowAllEvent();
	}
	
	@PutMapping("/acceptevent")
	public String AcceptEvent(@RequestParam int eid, @RequestParam int id) {
		return planner.AcceptEvent(eid,id);
	}
	
	//planner(user table) actions
	@GetMapping("/showallplanners")
	public List<UserModel> ShowAllPlanner() {
		return planner.ShowAllPlanner();
	}
	 

	// task actions
	@GetMapping("/showtasks")
	public List<TaskModel> showtasks(@RequestParam int eid) {
		return planner.showtasks(eid);
	}

	@PostMapping("/assigntasks")
	public ResponseEntity<TaskModel> assignTaskToStaff(@RequestBody planner_task plannertask) {
		TaskModel assignedTask = planner.assignTaskToStaff(
				plannertask.getTaskId(),
				plannertask.getStaffId()
				);
		return ResponseEntity.ok(assignedTask);
	}
	
	@PutMapping("/TaskStatus")
	public String TaskStatus(@RequestParam String status, @RequestParam String taskid){
		  Integer result = planner.TaskStatus(status, taskid);
		  if (result==null || result==0) {
				return "Status Cant be Updated";
			}
			else {
				return "Status updated";
			}
	}
}
