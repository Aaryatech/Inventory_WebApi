package com.inventory.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.TallySaleBill;

@Repository
public interface TallySaleBillUpdateRepository extends JpaRepository<TallySaleBill, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE TallySaleBill i SET i.isTallySync =:isTallySync  WHERE i.billNo=:billNo")
	int updateSalesVoucher(@Param("billNo")int billNo,@Param("isTallySync") int isTallySync);

}
