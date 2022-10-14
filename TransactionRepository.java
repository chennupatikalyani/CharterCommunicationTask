package com.retailer.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.retailer.rewards.entity.Transactions;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transactions,Long> {
    public List<Transactions> findAllByCustomerId(Long customerId);

    public List<Transactions> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,Timestamp to);
}
