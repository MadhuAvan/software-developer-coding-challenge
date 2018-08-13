package com.trade.rev.traderev.controller;

import com.trade.rev.traderev.model.Bid;
import com.trade.rev.traderev.model.Customer;
import com.trade.rev.traderev.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bidding")
public class BidController {

    @Autowired
    BidService bidService;

    @PostMapping
    public ResponseEntity<Bid> postBid(@RequestBody Bid bid) {
        Optional<Bid> bidResp = bidService.postBid(bid);
        if (bidResp.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(bidResp.get());
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/{bidId}")
    public ResponseEntity<Bid> getBid(@PathVariable long bidId) {
        Optional<Bid> bidResp = bidService.getBid(bidId);
        if (bidResp.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(bidResp.get());
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @PostMapping("/{carId}/{status}")
    public ResponseEntity<Bid> getBid(@PathVariable long carId,
                                      @PathVariable String status) {
        Bid bid = new Bid();
        bid.setStatus(status);
        Optional<Bid> postStatus = bidService.postStatus(carId, bid);

        if (postStatus.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(postStatus.get());
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

    @GetMapping("/highest/{carId}")
    public ResponseEntity<Customer> getHighestBid(@PathVariable long carId) {
        Optional<Customer> bidResp = bidService.getHighestBid(carId);
        if (bidResp.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(bidResp.get());
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
