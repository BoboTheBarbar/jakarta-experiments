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
import java.io.PrintWriter;

@WebServlet(name = "helloCar", value = "/hello-car")
public class CarServlet extends HttpServlet {

    @Inject
    CarManufacturer renault;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Specifcation specifcation = new Specifcation(Color.RED, EngineType.ELECTRIC);
        Car newCar = renault.createCar(specifcation);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello! This is your car!</h1>");
        out.println("<h1>" + newCar.getIdentifier() + "</h1>");
        out.println("<h1>" + newCar.getColor().name() + "</h1>");
        out.println("<h1>" + newCar.getEngineType().name() + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}

