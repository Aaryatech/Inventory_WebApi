package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.TallyItem;

@Repository
public interface TallyItemRepository extends JpaRepository<TallyItem, Integer>{

	@Query(value="select\n" + 
			"  m_item.item_id,\n" + 
			"  m_item.item_code,\n" + 
			"  m_item.item_name,\n" + 
			"  s_group.group_name,\n" + 
			"  s_item_category.cat_name,\n" + 
			"  m_item.uom_name,\n" + 
			"  m_item.weight,\n" + 
			"  m_item.pack_qty,\n" + 
			"  m_item.bms_min_qty,\n" + 
			"  m_item.bms_max_qty,\n" + 
			"  m_item.bms_rol_qty,\n" + 
			"  m_item.cgst,\n" + 
			"  m_item.sgst,\n" + 
			"  m_item.igst,\n" + 
			"  m_item.cess,\n" + 
			"  m_item.store_min_qty,\n" + 
			"  m_item.store_max_qty,\n" + 
			"  m_item.store_rol_qty,\n" + 
			"  m_item.hsn_code,\n" + 
			"  m_item.is_critical,\n" + 
			"  m_item.image,\n" + 
			"  m_item.del_status,\n" + 
			"  m_item.is_tally_sync\n" + 
			"  from m_item,s_group,s_item_category where m_item.del_status=0 and m_item.is_tally_sync=0 and m_item.group_id=s_group.group_id and m_item.cat_id=s_item_category.cat_id",nativeQuery=true)
	List<TallyItem> findByIsTallySync();


}
