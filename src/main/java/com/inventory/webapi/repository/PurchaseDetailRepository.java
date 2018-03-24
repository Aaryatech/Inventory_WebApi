package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.PurchaseDetail;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Integer>{
 

	List<PurchaseDetail> findByPurchaseIdAndDelStatus(int purchaseId, int delStatus);

	@Transactional
	@Modifying
	@Query(" UPDATE PurchaseDetail SET is_grn=1 where batch_no=:batchNo")
	int updateIsGrnInPurchaseDetail(@Param("batchNo")String batchNo);

	 

}
