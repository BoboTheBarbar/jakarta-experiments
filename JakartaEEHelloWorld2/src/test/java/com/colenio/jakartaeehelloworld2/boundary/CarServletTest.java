package com.colenio.jakartaeehelloworld2.boundary;

import static org.mockito.Mockito.mock;

import jakarta.enterprise.event.Event;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import com.colenio.jakartaeehelloworld2.control.CarFactory;
import com.colenio.jakartaeehelloworld2.control.CarRepository;

class CarServletTest {

    private final CarRepository repository = new CarRepository();
    private final CarFactory factory = new CarFactory();

    CarManufacturer manufacturer = new CarManufacturer(mock(Event.class), repository, factory);

    CarServlet carServlet = new CarServlet(manufacturer);

    @Test
    void getCarHTML() {
        String actual = carServlet.getCarHTML();
        Approvals.verify(actual);
    }
}
