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
public class StaffService {
@Autowired
UserRepo user;
@Autowired
EventRepo event;
@Autowired
TaskRepo taskrepo;

	// event actions
	public List<EventModel> ShowAllEvent(int sid) {
		List<EventModel> eventid = taskrepo.findAllEventsOfStaff(sid);	
		return eventid;
	}
 
	
	public String AcceptEvent(int eid, int sid) {
		List<TaskModel> taskslist = showtasks(eid,sid);
		Integer result = null;
		Integer result1 = null;
		for(TaskModel task:taskslist) {
			String tid = task.getTid();
			result1 = TaskStatus("Staff Accepted",tid);
		}
		if(result1>0) {
			result = event.accepteventbystaff(eid);
		}
		if(result==null||result==0) {
			return "No Datas Updated";
		}
		else {
			return "Data Updated";
		}
	}
	
	public List<TaskModel> showtasks(int eid, int sid) {
		 return taskrepo.findbyeid(eid,sid);
	} 
	
	// login and register

	public List<UserModel> register(List<UserModel> newuser) {
		return user.saveAll(newuser);
	}

	// task actions 
	public Integer TaskStatus(String status, String id) {
		return taskrepo.TaskStatus(status ,id);
	}

	public Integer updateVendorDetails(String task_id, String name, String contact) {
		Integer result = taskrepo.updateVendorDetails(task_id,name,contact);
		return result;
	}

	
	
}
