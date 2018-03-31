package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.LoginResponse;
import com.inventory.webapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findAllByDelStatus(int delStatus);

	User findByUserId(int userId);

	@Transactional
	@Modifying
	@Query(" UPDATE User SET del_status=1 WHERE user_id=:userId")
	int deleteUser(@Param("userId")int userId);

	User findByUserNameAndPasswordAndDelStatus(String userName, String pass, int delStatus); 

}
