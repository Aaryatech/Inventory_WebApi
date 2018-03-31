package com.inventory.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.TallyUpdateSupplier;

public interface TallyUpdateSupplierRepository extends JpaRepository<TallyUpdateSupplier, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE TallyUpdateSupplier i SET i.in1 =:isTallySync  WHERE i.suppId=:id")
	int updateSupplier(@Param("id")int id,@Param("isTallySync") int isTallySync);

}
