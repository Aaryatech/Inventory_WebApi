package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.TallyCustomer;

@Repository
public interface TallyCustomerRepository extends JpaRepository<TallyCustomer, Integer>{

	@Query(value="select cust_id,cust_name,gstin,address,cust_code,mobile,email,phone1,cust_type,conct_prsn,prsn_email,pan_no,is_same_state,credit_days,del_status\n" + 
			"from s_customer where del_status=0 and is_tally_sync=0",nativeQuery=true)
	List<TallyCustomer> findByIsTallySync();

}
