package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.PurchaseHeader;

public interface PurchaseHeaderRepository extends JpaRepository<PurchaseHeader, Integer>{

	@Query(value="select * from t_purchase_header where (date between :fromDate and :toDate) and del_status=0",nativeQuery=true)
	List<PurchaseHeader> getPurchaseHeader(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	PurchaseHeader findByPurchaseId(int purchaseId);

	
	@Transactional
	@Modifying
	@Query(" UPDATE PurchaseHeader SET is_paid=2 WHERE purchase_id=:purchaseId")  
	int updateIsPaid(@Param("purchaseId")int purchaseId ); 

}
