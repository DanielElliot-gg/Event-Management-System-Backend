package com.eventmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventmanagement.model.EventModel;
import com.eventmanagement.model.TaskModel;

import jakarta.transaction.Transactional;

@Repository
public interface TaskRepo extends JpaRepository<TaskModel, String> {

	@Modifying
	@Transactional
	@Query("update TaskModel task set task.status= :status where task.tid= :id")
	Integer TaskStatus(@Param("status") String status,@Param("id") String id);

	
	@Query("select t from TaskModel t where t.eventmodel.eid=:eventid and t.usermodel.uid=:staffid")
	List<TaskModel> findbyeid(@Param("eventid") int eid, @Param("staffid") int sid);
	
	@Query("select t from TaskModel t where t.eventmodel.eid=:eventid")
	List<TaskModel> findbyeid(@Param("eventid") int eid);
	
	@Query("select t from TaskModel t where t.eventmodel.eid=:eventid")
	List<TaskModel> findalltaskofevent(@Param("eventid") int eid);

	@Modifying
	@Transactional
	@Query("update TaskModel task set task.vendor_name= :vname,task.vendor_contact= :vcontact where task.tid= :id")
	Integer updateVendorDetails(@Param("id")String task_id,@Param("vname") String name,@Param("vcontact") String contact);

	
	@Query("select t.eventmodel from TaskModel t where t.usermodel.uid=:staffid")
	List<EventModel> findAllEventsOfStaff(@Param("staffid") int sid);


	@Query("select t.tid from TaskModel t where t.eventmodel.eid=:eventid")
	ArrayList<String> findlisttask(@Param("eventid") int eid);

	
	
}
