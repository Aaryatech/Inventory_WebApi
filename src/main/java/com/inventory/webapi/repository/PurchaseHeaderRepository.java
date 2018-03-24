package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.PurchaseHeader;

public interface PurchaseHeaderRepository extends JpaRepository<PurchaseHeader, Integer>{

	@Query(value="select * from t_purchase_header where (date between :fromDate and :toDate) and del_status=0",nativeQuery=true)
	List<PurchaseHeader> getPurchaseHeader(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	PurchaseHeader findByPurchaseId(int purchaseId);

}
