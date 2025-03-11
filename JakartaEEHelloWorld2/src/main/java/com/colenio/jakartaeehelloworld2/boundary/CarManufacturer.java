package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.ejb.Stateless;

@Stateless
public class CarManufacturer {

    public CarManufacturer() {}

    public Car createCar(Specifcation specifcation) {
        Car car = new Car();
        car.setIdentifier("Renault Corsa");
        car.setColor(specifcation.getColor());
        car.setEngineType(specifcation.getEngineType());

        return car;
    }
}
