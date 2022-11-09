package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.hibernate.TblCustomerInstance;

@Repository
public interface InstanceRepository extends JpaRepository<TblCustomerInstance, String>,JpaSpecificationExecutor<TblCustomerInstance>{

	
	Optional<TblCustomerInstance> findById(String id);
	
	@Query(value = "SELECT * FROM MPOCPOCODADM.MPOCPOCOD_INSTANCE WHERE public_id_value = ?1 " , nativeQuery = true)
	List<TblCustomerInstance> findByMobileNoRaw(String mobileNo);
	
}
 