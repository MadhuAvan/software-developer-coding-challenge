package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Bid;
import com.trade.rev.traderev.model.Customer;
import com.trade.rev.traderev.repository.BidRepository;
import com.trade.rev.traderev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Bid> postBid(Bid bid) {
        return Optional.of(repository.save(bid));
    }

    @Override
    public Optional<Bid> getBid(long bidId) {
        return repository.findById(bidId);
    }

    @Override
    public Optional<Bid> postStatus(long carId, Bid bid) {
        return Optional.of(repository.save(bid));
    }

    @Override
    public Optional<Customer> getHighestBid(long carId) {
        Optional<List<Bid>> optionalBids = repository.findByCarId(carId);
        long customerId = 0l;
        long price = 0l;
        if (optionalBids.isPresent()) {
            for (Bid b : optionalBids.get()) {
                if (b.getStatus().equalsIgnoreCase("available")) {
                    throw new RuntimeException("car still available for bidding");
                }
                if (b.getPrice() > price) {
                    price = b.getPrice();
                    customerId = b.getCustomerId();
                }
            }
        } else {
            throw new RuntimeException("no bid found against the car");
        }
        return customerRepository.findById(customerId);
    }
}
