package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Optional<List<Car>> getCars();
    Optional<List<Car>> getCarsByAvailaibility(boolean availibility);
    Optional<Car> getCarById(long cardId);
    Optional<Car> saveCar(Car car);
}
