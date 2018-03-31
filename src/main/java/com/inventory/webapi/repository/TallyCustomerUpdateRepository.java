package com.inventory.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.TallyCustomerUpdate;

public interface TallyCustomerUpdateRepository extends JpaRepository<TallyCustomerUpdate, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE TallyCustomerUpdate i SET i.isTallySync =:isTallySync  WHERE i.custId=:id")
	int updateCustomer(@Param("id")int id,@Param("isTallySync") int isTallySync);

}
