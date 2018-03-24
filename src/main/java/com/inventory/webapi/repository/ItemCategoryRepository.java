package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer>{

	List<ItemCategory> findAllByDelStatus(int delStatus);

	ItemCategory findByCatId(int catId);

	
	@Transactional
	@Modifying
	@Query(" UPDATE ItemCategory SET del_status=1 WHERE cat_id=:catId") 
	int deleteCategory(@Param("catId")int catId);

	List<ItemCategory> findByGroupIdAndDelStatus(int groupId,int delStatus);  

}
