package com.retailer.rewards.repository;

import org.springframework.data.repository.CrudRepository;

import com.retailer.rewards.entity.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails,Long> {
    public CustomerDetails findByCustomerId(Long customerId);
}
