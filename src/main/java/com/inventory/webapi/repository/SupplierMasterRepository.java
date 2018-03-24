package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.SupplierMaster;

public interface SupplierMasterRepository extends JpaRepository<SupplierMaster, Integer>{

	List<SupplierMaster> findAllByDelStatus(int delStatus);

	SupplierMaster findBySuppId(int suppId);

	
	@Transactional
	@Modifying
	@Query(" UPDATE SupplierMaster SET del_status=1 WHERE supp_id=:suppId")
	int deleteSuppllier(@Param("suppId")int suppId);

}
