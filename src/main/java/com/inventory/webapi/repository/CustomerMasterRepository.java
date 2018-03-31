package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer>{

	List<CustomerMaster> findAllByDelStatus(int delStatus);

	CustomerMaster findByCustId(int custId);

	@Transactional
	@Modifying
	@Query(" UPDATE CustomerMaster SET del_status=1 WHERE cust_id=:custId") 
	int deleteCustomer(@Param("custId")int custId);

	@Query(value="select cust_id,cust_name,gstin,address,cust_code,mobile,email,phone1,cust_type,conct_prsn,prsn_email,pan_no,is_same_state,credit_days,del_status from s_customer where del_status=0 and cust_id NOT IN(select cust_id from t_bill_header where (select CURDATE()\r\n" + 
			"> DATE_ADD(t_bill_header.invoice_date, INTERVAL 30 DAY)) and t_bill_header.bill_status=2 group by t_bill_header.cust_id)",nativeQuery=true)
	List<CustomerMaster> findUnBloked();  

}
