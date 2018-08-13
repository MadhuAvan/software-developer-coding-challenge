package com.trade.rev.traderev.repository;

import com.trade.rev.traderev.model.Bid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends CrudRepository<Bid ,Long> {
    Optional<List<Bid>> findByCarId(long carId);
}
