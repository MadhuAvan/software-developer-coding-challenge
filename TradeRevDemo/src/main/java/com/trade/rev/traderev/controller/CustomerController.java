package com.trade.rev.traderev.controller;

import com.trade.rev.traderev.model.Customer;
import com.trade.rev.traderev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestParam String firstName,
                                               @RequestParam String lastName,
                                                 @RequestParam String email,
                                                     @RequestParam String phone) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);

        Optional<Customer> customerResp = customerService.addCustomer(customer);

        if(customerResp.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

    @RequestMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestParam Long customerId,
                                                 @RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam String email,
                                                 @RequestParam String phone) {

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);

        ResponseEntity<Object> resp = customerService.updateCustomer(customer);
        if(resp.getStatusCode().is2xxSuccessful()){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();

    }

    @RequestMapping("/deleteCustomer")
    public ResponseEntity<Customer> deleteCustomer(@RequestParam Long customerId){
        customerService.deleteCustomer(customerId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
