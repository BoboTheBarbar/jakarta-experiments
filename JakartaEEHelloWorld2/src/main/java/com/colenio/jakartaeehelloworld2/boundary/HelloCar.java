package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.Color;
import com.colenio.jakartaeehelloworld2.entity.EngineType;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloCar", value = "/hello-car")
public class HelloCar extends HttpServlet {

    @Inject
    CarManufacturer renault;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Specifcation specifcation = new Specifcation(Color.RED, EngineType.ELECTRIC);
        Car newCar = renault.createCar(specifcation);
    }

    /** TODO:
     * 1. Mit einem Car Manufacturer ein default car mit Specification bauen.
     * 2. Mit einer Car Factory und einem repository den Manufacturer bauen.
     * 3. Ausgabe in Boundary anpassen.
     */



    @Override
    public void destroy() {
    }
}