package com.trade.rev.traderev.service;

import com.trade.rev.traderev.model.Car;
import com.trade.rev.traderev.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceProvider implements CarService {

    @Autowired
    private CarRepository carRepository;

    public Optional<List<Car>> getCars() {
        List<Car> carList = new ArrayList<>();
        carRepository.findAll().forEach(carList::add);
        return Optional.of(carList);
    }

    public Optional<List<Car>> getCarsByAvailaibility(boolean availability) {
        return carRepository.findByAvailability(availability);
    }

    public Optional<Car> getCarById(long cardId) {
        return carRepository.findById(cardId);
    }

    public Optional<Car> saveCar(Car car) {
        return Optional.of(carRepository.save(car));
    }


}
