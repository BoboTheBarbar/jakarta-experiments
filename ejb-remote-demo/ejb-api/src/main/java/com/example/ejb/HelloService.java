package com.example.ejb;

import jakarta.ejb.Remote;

@Remote
public interface HelloService {
    String sayHello(String name);
}
