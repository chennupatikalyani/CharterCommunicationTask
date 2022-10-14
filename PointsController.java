package com.retailer.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.rewards.entity.CustomerDetails;
import com.retailer.rewards.model.Points;
import com.retailer.rewards.repository.CustomerRepository;
import com.retailer.rewards.service.RestService;

@RestController
@RequestMapping("/customers")
public class PointsController {

    @Autowired
    RestService pointsService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{customerId}/points",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Points> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        CustomerDetails customer = customerRepository.findByCustomerId(customerId);
        if(customer == null)
        {
        	throw new RuntimeException("Invalid / Missing customer Id ");
        }
        Points customerPoints = pointsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerPoints,HttpStatus.OK);
        
    }

}
