package com.inventory.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.TSetting;

public interface TSettingRepository extends JpaRepository<TSetting, Integer>{

	TSetting findBySettingKey(String key);

	@Transactional
	@Modifying
	@Query(" UPDATE TSetting SET setting_value=:value WHERE setting_key=:key")  
	int updateValue(@Param("value")int value,@Param("key")String key); 

}
