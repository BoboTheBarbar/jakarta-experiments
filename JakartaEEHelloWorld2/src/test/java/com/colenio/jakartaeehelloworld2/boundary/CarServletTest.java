package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.control.CarFactory;
import com.colenio.jakartaeehelloworld2.control.CarRepository;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class CarServletTest {

    private final CarRepository repository = new CarRepository();
    private final CarFactory factory = new CarFactory();
    CarManufacturer manufacturer = new CarManufacturer(factory, repository);


    CarServlet carServlet = new CarServlet(manufacturer);

    @Test
    void getCarHTML() {
        String actual = carServlet.getCarHTML();
        Approvals.verify(actual);
    }
}