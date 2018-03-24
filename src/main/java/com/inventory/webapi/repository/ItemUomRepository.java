package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional; 
import com.inventory.webapi.model.ItemUom;

public interface ItemUomRepository extends JpaRepository<ItemUom, Integer>{

	 
	List<ItemUom> findAllByDelStatus(int delStatus);

	ItemUom findByUomId(int uomId);

	@Transactional
	@Modifying
	@Query(" UPDATE ItemUom SET del_status=1 WHERE uom_id=:uomId") 
	int deleteUom(@Param("uomId")int uomId); 
	 

}
