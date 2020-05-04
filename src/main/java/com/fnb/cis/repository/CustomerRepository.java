package com.fnb.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fnb.cis.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
