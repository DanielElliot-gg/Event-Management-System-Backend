package com.eventmanagement.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventmanagement.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
	@Query("select uid from UserModel where username= :username and upassword= :password")
	Integer login(@Param("username") String uname,@Param("password") String pwd);

	@Query("select u from UserModel u where u.uid=:staffId and u.role='staff'")
	Optional<UserModel> findByIdAndRole(int staffId);

	@Query(value = "SELECT role,uid FROM user  WHERE BINARY username = :user AND BINARY upassword = :pass", nativeQuery = true)
	ArrayList<Object> loginbyid(@Param("user") String username, @Param("pass") String password);
	
	@Query("select u from UserModel u where u.role='staff'")
	List<UserModel> findByRole();
	
	Optional<UserModel> findByUsername(String username);
 
}
