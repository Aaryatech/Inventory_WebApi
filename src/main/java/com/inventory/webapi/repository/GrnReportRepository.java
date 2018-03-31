package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.GrnReport;

public interface GrnReportRepository extends JpaRepository<GrnReport, Integer>{

	@Query(value=" select\r\n" + 
			"    d.grn_detail_id, \r\n" + 
			"    d.item_id,\r\n" + 
			"    d.item_name,\r\n" + 
			"    d.hsn_code, \r\n" + 
			"    sum(d.qty) as qty,\r\n" + 
			"    sum(d.total) as total\r\n" + 
			"from \r\n" + 
			"    grn_gvn_detail d,\r\n" + 
			"    grn_gvn h\r\n" + 
			"where \r\n" + 
			"    h.date between :fromDate and :toDate \r\n" + 
			"    and h.grn_id=d.grn_id\r\n" + 
			"    and h.grn_type=:grnType \r\n" + 
			"group by \r\n" + 
			"    d.item_id",nativeQuery=true)
	List<GrnReport> grnItemWiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("grnType") int grnType);

	@Query(value="select\r\n" + 
			"    d.grn_detail_id, \r\n" + 
			"    d.item_id,\r\n" + 
			"    d.item_name,\r\n" + 
			"    d.hsn_code, \r\n" + 
			"    sum(d.qty) as qty,\r\n" + 
			"    sum(d.total) as total\r\n" + 
			"from \r\n" + 
			"    grn_gvn_detail d,\r\n" + 
			"    grn_gvn h\r\n" + 
			"where \r\n" + 
			"    h.date between :fromDate and :toDate\r\n" + 
			"    and h.grn_id=d.grn_id\r\n" + 
			"    and h.grn_type=:grnType \r\n" + 
			"    and h.supp_id=:suppId\r\n" + 
			"group by \r\n" + 
			"    d.item_id ",nativeQuery=true)
	List<GrnReport> grnItemWiseReportWithSuppId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("grnType") int grnType,@Param("suppId") int suppId);
 

}
