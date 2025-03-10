package com.colenio.jakartaeehelloworld2;

import jakarta.ejb.Stateless;

@Stateless
public class MessageBean {
    public String getMessage() {
        return "Hello my friend!";
    }
}
