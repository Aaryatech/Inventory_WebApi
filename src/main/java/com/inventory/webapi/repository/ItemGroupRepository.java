package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.ItemGroup; 

public interface ItemGroupRepository extends JpaRepository<ItemGroup, Integer>{

	List<ItemGroup> findAllByDelStatus(int delStatus);

	ItemGroup findBygroupId(int groupId);

	@Transactional
	@Modifying
	@Query(" UPDATE ItemGroup SET del_status=1 WHERE group_id=:groupId") 
	int deleteGroup(@Param("groupId")int groupId);  

}
