package com.colenio.jakartaeehelloworld2.control;

import jakarta.ejb.Stateless;

@Stateless
public class MessageBean {
    public String getMessage() {
        return "Hello bean!";
    }
}
