package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Customer;
import com.trade.rev.traderev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository ;

    @Override
    public Optional<Customer> addCustomer(Customer customer) {
         repository.save(customer);
        return Optional.of(customer);
    }

    @Override
    public ResponseEntity<Object> updateCustomer(Customer customer) {
         Optional<Customer> updateCustomer = repository.findById(customer.getId());
         if(!updateCustomer.isPresent())
             return ResponseEntity.notFound().build();
         customer.setId(customer.getId());
         repository.save(customer);

         return ResponseEntity.status(HttpStatus.OK).build();
         
    }

    @Override
    public ResponseEntity<Object> deleteCustomer(Long cust_id) {

        repository.deleteById(cust_id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
