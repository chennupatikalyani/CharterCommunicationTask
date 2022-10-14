package com.retailer.rewards.service;

import com.retailer.rewards.model.Points;



public interface RestService {
    public Points getRewardsByCustomerId(Long customerId);
}
