package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Bid;
import com.trade.rev.traderev.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface BidService {

    Optional<Bid> postBid(Bid bid);

    Optional<Bid> getBid(long bidId);

    Optional<Bid> postStatus(long carId , Bid bid);

    Optional<Customer> getHighestBid(long carId);
}
