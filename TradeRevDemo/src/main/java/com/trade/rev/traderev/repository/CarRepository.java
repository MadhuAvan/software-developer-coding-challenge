package com.trade.rev.traderev.repository;

import com.trade.rev.traderev.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Optional<List<Car>> findByAvailability(boolean availability);
}
