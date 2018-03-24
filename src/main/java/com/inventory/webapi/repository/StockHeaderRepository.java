package com.inventory.webapi.repository;
 
import org.springframework.data.jpa.repository.JpaRepository; 
 
import com.inventory.webapi.model.StockHeader;

public interface StockHeaderRepository extends JpaRepository<StockHeader, Integer>{

	StockHeader findByStatus(int status);

	

}
