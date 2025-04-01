package com.example.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class HelloServiceBean implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hallo, " + name + "! Grüße vom Remote EJB 👋";
    }
}
