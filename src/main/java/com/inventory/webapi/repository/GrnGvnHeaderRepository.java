package com.inventory.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.webapi.model.GrnGvnHeader;

public interface GrnGvnHeaderRepository extends JpaRepository<GrnGvnHeader, Integer>{

}
