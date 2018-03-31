package com.inventory.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.TallyPurchaseBill;
@Repository
public interface TallyPurchaseBillUpdateRepository extends JpaRepository<TallyPurchaseBill, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE TallyPurchaseBill i SET i.isTallySync =:isTallySync  WHERE i.purchaseId=:purchaseId")
	int updatePurchaseBill(@Param("purchaseId")int purchaseId,@Param("isTallySync") int isTallySync);

}
