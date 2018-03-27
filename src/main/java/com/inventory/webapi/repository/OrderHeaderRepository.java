package com.inventory.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.Order;

@Repository
public interface OrderHeaderRepository extends JpaRepository<Order, Integer>{

	@Transactional
	@Modifying
	@Query(" UPDATE Order SET order_status=2,is_bill_generated=1 WHERE order_id=:orderId") 
	int updateOrderStatus(@Param("orderId")int orderId);

}
