package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer>{

	List<ItemMaster> findAllByDelStatus(int delStatus);

	ItemMaster findByItemId(int itemId);

	@Transactional
	@Modifying
	@Query(" UPDATE ItemMaster SET del_status=1 WHERE item_id=:itemId")
	int deleteItem(@Param("itemId")int itemId); 

}
