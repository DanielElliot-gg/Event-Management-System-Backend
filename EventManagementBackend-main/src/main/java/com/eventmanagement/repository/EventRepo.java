package com.eventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventmanagement.model.EventModel;

import jakarta.transaction.Transactional;

@Repository
public interface EventRepo extends JpaRepository<EventModel,Integer> {
	@Modifying
	@Transactional
	@Query("update EventModel event set event.estatus= :status where event.eid= :id")
	Integer EventStatus(@Param("status") String status,@Param("id") int id);

	
	@Query("select em from EventModel em where em.cid=:clientid")
	List<EventModel> findalleventbycid(@Param("clientid") int id);

	@Modifying
	@Transactional
	@Query("Update EventModel e  set e.estatus='Planner Accepted', e.pid=:uid where e.eid=:evid")
	Integer acceptevent(@Param("evid")int eid, @Param("uid") int id);
	
	
	@Modifying
	@Transactional
	@Query("Update EventModel e  set e.estatus='Staff Accepted' where e.eid=:evid")
	Integer accepteventbystaff(@Param("evid") int eid);
	
	
	List<EventModel> findByCid(int cid);
	
	
	
 
}
