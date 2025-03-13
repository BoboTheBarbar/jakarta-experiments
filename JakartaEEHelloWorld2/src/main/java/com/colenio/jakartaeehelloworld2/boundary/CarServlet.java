package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.entity.Car;
import com.colenio.jakartaeehelloworld2.entity.Color;
import com.colenio.jakartaeehelloworld2.entity.EngineType;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloCar", value = "/hello-car")
public class CarServlet extends HttpServlet {

    CarManufacturer renault;

    @Inject
    public CarServlet(CarManufacturer renault) {
        this.renault = renault;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(getCarHTML());
    }

    public String getCarHTML() {
        Specifcation specifcation = new Specifcation(Color.RED, EngineType.ELECTRIC);
        Car newCar = renault.createCar(specifcation);
        String resultHtml = """
                <html><body>
                <h1>Hello! This is your car!</h1>
                <h1> %s </h1>
                <h1> %s </h1>
                <h1> %s </h1>
                </body></html>
                """;
        return resultHtml.formatted(newCar.getIdentifier(), newCar.getColor().name(), newCar.getEngineType().name());
    }

    @Override
    public void destroy() {
    }
}
