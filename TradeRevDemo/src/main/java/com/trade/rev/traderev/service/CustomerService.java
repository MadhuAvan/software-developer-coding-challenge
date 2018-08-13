package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> addCustomer(Customer customer);
    ResponseEntity<Object> updateCustomer(Customer customer);
    ResponseEntity<Object> deleteCustomer(Long cust_id);

}
