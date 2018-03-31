package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.GrnGvnHeader;

public interface GrnGvnHeaderRepository extends JpaRepository<GrnGvnHeader, Integer>{

	@Query(value="select * from grn_gvn where (date between :fromDate and :toDate) and del_status=0",nativeQuery=true)
	List<GrnGvnHeader> findByGrnListByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	GrnGvnHeader findByGrnId(int grnId);

}
