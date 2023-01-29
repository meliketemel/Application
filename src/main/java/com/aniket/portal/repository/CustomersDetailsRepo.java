package com.aniket.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aniket.portal.model.CustomersDetailsModel;

@Repository
public interface CustomersDetailsRepo extends JpaRepository<CustomersDetailsModel,Long>{

	@Query(value = "select max(id) from cstmrs_dtls_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "select * from cstmrs_dtls_mstr where Tc_No=?1", nativeQuery = true) 
	CustomersDetailsModel fetchuserid(String customerid);
}
