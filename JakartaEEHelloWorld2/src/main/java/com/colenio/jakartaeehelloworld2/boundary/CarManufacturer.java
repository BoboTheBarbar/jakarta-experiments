package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.control.CarFactory;
import com.colenio.jakartaeehelloworld2.control.CarRepository;
import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class CarManufacturer {
    private final CarFactory factory;
    private final CarRepository repository;

    @Inject
    public CarManufacturer(CarFactory factory, CarRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Car createCar(Specifcation specifcation) {
        Car car = factory.createCar(specifcation);
        repository.save(car);
        return car;
    }
}
