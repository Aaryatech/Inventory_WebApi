package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.TallySupplier;

@Repository
public interface TallySupplierRepository  extends JpaRepository<TallySupplier, Integer>{

	
	List<TallySupplier> findAllByDelStatusAndIsTallySync(int i, int j);


}
