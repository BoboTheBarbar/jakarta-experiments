package com.colenio.jakartaeehelloworld2;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class MessageProducer {
    @Produces
    public Message myMessage() {
        return new Message("Hello producer!");
    }
}
