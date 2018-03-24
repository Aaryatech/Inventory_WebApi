package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer>{

	List<CustomerMaster> findAllByDelStatus(int delStatus);

	CustomerMaster findByCustId(int custId);

	@Transactional
	@Modifying
	@Query(" UPDATE CustomerMaster SET del_status=1 WHERE cust_id=:custId") 
	int deleteCustomer(@Param("custId")int custId);  

}
