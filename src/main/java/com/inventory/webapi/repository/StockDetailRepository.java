package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.inventory.webapi.model.StockDetail;

public interface StockDetailRepository extends JpaRepository<StockDetail, Integer>{

	List<StockDetail> findByStockId(int stockId);

	

}
