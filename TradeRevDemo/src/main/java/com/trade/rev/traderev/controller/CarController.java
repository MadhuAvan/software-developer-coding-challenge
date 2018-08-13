package com.trade.rev.traderev.controller;

import com.trade.rev.traderev.model.Car;
import com.trade.rev.traderev.model.Stat;
import com.trade.rev.traderev.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        Optional<List<Car>> optionalCarList = carService.getCars();
        if (optionalCarList.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCarList.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCarList.get());
        }
    }

    @GetMapping("/available/{availability}")
    public ResponseEntity<List<Car>> getListByStatus(@PathVariable boolean availability) {
        Optional<List<Car>> optionalCarList = carService.getCarsByAvailaibility(availability);
        if (optionalCarList.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCarList.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCarList.get());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarsById(@PathVariable long id) {
        Optional<Car> optionalCar = carService.getCarById(id);
        if (optionalCar.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCar.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCar.get());
        }
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Optional<Car> optionalCar = carService.saveCar(car);
        if (optionalCar.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCar.get());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCar.get());
        }
    }

}
