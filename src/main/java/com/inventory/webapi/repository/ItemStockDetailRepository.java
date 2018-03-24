package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.ItemStockDetail; 

public interface ItemStockDetailRepository extends JpaRepository<ItemStockDetail, Integer>{
	
	@Query(value="SELECT m_item.item_id, m_item.item_name,\r\n" + 
			"        coalesce(t.stock_detail_id,\r\n" + 
			"        0)as stock_detail_id,\r\n" + 
			"        coalesce(t.stock_id,\r\n" + 
			"        0)as stock_id,\r\n" + 
			"        coalesce(t.opening_stock,\r\n" + 
			"        0)as opening_stock,\r\n" + 
			"        coalesce(t.total_purchase,\r\n" + 
			"        0)as total_purchase,\r\n" + 
			"        coalesce(t.total_sale,\r\n" + 
			"        0)as total_sale,\r\n" + 
			"        coalesce(t.grn,\r\n" + 
			"        0) as grn,\r\n" + 
			"        coalesce(t.closing_stock,\r\n" + 
			"        0) as closing_stock,\r\n" + 
			"        coalesce(t.last_wholesale_rate,\r\n" + 
			"        0)as last_wholesale_rate,\r\n" + 
			"        coalesce(t.last_retail_rate,\r\n" + 
			"        0)as last_retail_rate,\r\n" + 
			"        coalesce(t.last_purchase_rate,\r\n" + 
			"        0)as last_purchase_rate,\r\n" + 
			"        coalesce(t.total,\r\n" + 
			"        0)as total  \r\n" + 
			"    FROM\r\n" + 
			"        m_item  \r\n" + 
			"    LEFT JOIN\r\n" + 
			"        (\r\n" + 
			"            select\r\n" + 
			"                t.stock_detail_id,\r\n" + 
			"                t.stock_id,\r\n" + 
			"                t.item_id,\r\n" + 
			"                t.item_name,\r\n" + 
			"                t.total_purchase,\r\n" + 
			"                t.closing_stock,\r\n" + 
			"                t.last_wholesale_rate,\r\n" + 
			"                t.last_retail_rate,\r\n" + 
			"                t.last_purchase_rate,\r\n" + 
			"                t.total_sale,\r\n" + 
			"                t.grn,\r\n" + 
			"                t.total,\r\n" + 
			"                t.opening_stock\r\n" + 
			"            from\r\n" + 
			"                t_stock_detail t \r\n" + 
			"            where\r\n" + 
			"                t.stock_id=:stockId \r\n" + 
			"        ) t  \r\n" + 
			"            ON m_item.item_id = t.item_id \r\n" + 
			"    where\r\n" + 
			"        m_item.del_status=0",nativeQuery=true)
	List<ItemStockDetail> getDetailed(@Param("stockId")int stockId);

}
