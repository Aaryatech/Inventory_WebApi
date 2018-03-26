package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer>{

	List<BillDetail> findByBillNo(int billNo);

}
