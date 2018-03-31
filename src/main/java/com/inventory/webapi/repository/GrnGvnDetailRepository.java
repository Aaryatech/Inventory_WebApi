package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.webapi.model.GrnGvnDetail;

public interface GrnGvnDetailRepository extends JpaRepository<GrnGvnDetail, Integer>{

	List<GrnGvnDetail> findByGrnId(int grnId);

}
