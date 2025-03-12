package com.colenio.jakartaeehelloworld2.control;

import com.colenio.jakartaeehelloworld2.entity.CarCreated;
import jakarta.enterprise.event.Observes;

public class CarCreationListener {
    public void carCreatedEvent(@Observes CarCreated carCreated) {
        System.out.println("This car was created: " + carCreated.identifier);
    }
}
