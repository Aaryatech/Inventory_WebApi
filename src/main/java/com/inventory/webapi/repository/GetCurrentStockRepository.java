package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.GetCurrentStock; 

public interface GetCurrentStockRepository extends JpaRepository<GetCurrentStock, Integer>{
	
	@Query(value=" SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_name,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.opening_stock \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:date \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_purchase_detail.rec_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_purchase_detail,\r\n" + 
			"            t_purchase_header \r\n" + 
			"        where\r\n" + 
			"            t_purchase_header.date=:date \r\n" + 
			"            AND t_purchase_header.purchase_id=t_purchase_detail.purchase_id \r\n" + 
			"            AND m_item.item_id=t_purchase_detail.item_id),\r\n" + 
			"        0) AS total_purchase,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM( t_bill_detail.bill_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_bill_header,\r\n" + 
			"            t_bill_detail \r\n" + 
			"        WHERE\r\n" + 
			"            t_bill_header.invoice_date =:date \r\n" + 
			"            AND t_bill_header.bill_no=t_bill_detail.bill_no \r\n" + 
			"            AND m_item.item_id=t_bill_detail.item_id),\r\n" + 
			"        0) AS total_sale,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM( grn_gvn_detail.qty)  \r\n" + 
			"        FROM\r\n" + 
			"            grn_gvn_detail,\r\n" + 
			"            grn_gvn \r\n" + 
			"        WHERE\r\n" + 
			"            grn_gvn.date=:date \r\n" + 
			"            AND grn_gvn.grn_id=grn_gvn_detail.grn_id \r\n" + 
			"            AND m_item.item_id=grn_gvn_detail.item_id),\r\n" + 
			"        0)  AS total_grn ,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.closing_stock \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:date \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS closing_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_purchase_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:date \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_purchase_rate,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_wholesale_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:date \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_wholesale_rate,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_retail_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:date \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_retail_rate \r\n" + 
			"    FROM\r\n" + 
			"        m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.del_status=0 ",nativeQuery=true)
	List<GetCurrentStock> getCurrentStock(@Param("date")String date);

	@Query(value="SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_name,\r\n" + 
			"        coalesce((Select\r\n" + 
			"             SUM( t_stock_detail.opening_stock )\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"             SUM( t_stock_detail.total_purchase )\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date between :fromDate and :toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS total_purchase,\r\n" + 
			"        coalesce((Select\r\n" + 
			"             SUM( t_stock_detail.total_sale )\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date between :fromDate and :toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS total_sale,\r\n" + 
			"        coalesce((Select\r\n" + 
			"             SUM( t_stock_detail.grn )\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date between :fromDate and :toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0)  AS total_grn ,\r\n" + 
			"        coalesce((Select\r\n" + 
			"             SUM( t_stock_detail.closing_stock )\r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date = :toDate\r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0)  AS closing_stock ,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_purchase_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date =:toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_purchase_rate,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_wholesale_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_wholesale_rate,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            t_stock_detail.last_retail_rate \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:toDate \r\n" + 
			"            AND t_stock_header.stock_id=t_stock_detail.stock_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) as last_retail_rate \r\n" + 
			"    FROM\r\n" + 
			"        m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.del_status=0 \r\n" + 
			"        and m_item.cat_id=:catId",nativeQuery=true)
	List<GetCurrentStock> getStockBetween(@Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("catId")int catId);

}
