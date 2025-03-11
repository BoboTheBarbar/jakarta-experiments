package com.colenio.jakartaeehelloworld2.control;

import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;

public class CarFactory {
    public Car createCar(Specifcation specifcation) {
        Car car = new Car();
        car.setIdentifier("Renault Corsa");
        car.setColor(specifcation.getColor());
        car.setEngineType(specifcation.getEngineType());
        return car;
    }
}
