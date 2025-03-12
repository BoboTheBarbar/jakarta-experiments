package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.control.CarFactory;
import com.colenio.jakartaeehelloworld2.control.CarRepository;
import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.CarCreated;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@Stateless
public class CarManufacturer {
    private final CarFactory factory;
    private final CarRepository repository;

    private final Event<CarCreated> carCreationPublisher;

    @Inject
    public CarManufacturer(Event<CarCreated> carCreationPublisher, CarRepository repository, CarFactory factory) {
        this.carCreationPublisher = carCreationPublisher;
        this.repository = repository;
        this.factory = factory;
    }

    public Car createCar(Specifcation specifcation) {
        Car car = factory.createCar(specifcation);
        repository.save(car);
        carCreationPublisher.fire(new CarCreated(car.getIdentifier()));
        return car;
    }
}
