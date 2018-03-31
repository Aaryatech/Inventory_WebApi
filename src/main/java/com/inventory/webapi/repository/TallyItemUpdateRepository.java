package com.inventory.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.TallyItemUpdate;
@Repository
public interface TallyItemUpdateRepository extends JpaRepository<TallyItemUpdate, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE TallyItemUpdate i SET i.isTallySync =:isTallySync  WHERE i.itemId=:id")
	int updateItem(@Param("id")int id,@Param("isTallySync") int isTallySync);

}
