package com.eventmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;
import com.eventmanagement.model.UserModel;
import com.eventmanagement.repository.EventRepo;
import com.eventmanagement.repository.TaskRepo;
import com.eventmanagement.repository.UserRepo;

@Service
public class PlannerService {
@Autowired 
UserRepo user;
@Autowired
TaskRepo taskrepo;
@Autowired
EventRepo event;

	// event actions 
	public List<EventModel> ShowAllEvent() {
		return event.findAll();
	}
	public String AcceptEvent(int eid, int pid) {
		List<TaskModel> taskslist = showtasks(eid);
		Integer result = null;
		Integer result1 = null;
		for(TaskModel task:taskslist) {
			String tid = task.getTid();
			result1 = TaskStatus("Planner Accepted",tid);
		}
		if(result1>0) {
			result = event.acceptevent(eid,pid);
		}
		if(result==null||result==0) {
			return "No Datas Updated";
		}
		else {
			return "Data Updated";
		}
	}
	// Planner finding action
	public List<UserModel> ShowAllPlanner() {
		return user.findByRole();
	}
	
	
	// task actions
	public List<TaskModel> showtasks(int eid) {
		 return taskrepo.findalltaskofevent(eid);
	} 
	
    public TaskModel assignTaskToStaff(String taskId, int staffId) {
        TaskModel task = taskrepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + taskId)); 
        UserModel staff = user.findByIdAndRole(staffId)
        		.orElseThrow(()-> new RuntimeException("Staff not founf with ID: " + staffId));
        task.setUsermodel(staff);
        return taskrepo.save(task);
    }
    
    public Integer TaskStatus(String status, String id) {
		return taskrepo.TaskStatus(status ,id);
	}
	
	

	
    
}
