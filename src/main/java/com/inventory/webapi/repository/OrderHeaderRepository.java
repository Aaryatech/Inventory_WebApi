package com.inventory.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.Order;

@Repository
public interface OrderHeaderRepository extends JpaRepository<Order, Integer>{

}
