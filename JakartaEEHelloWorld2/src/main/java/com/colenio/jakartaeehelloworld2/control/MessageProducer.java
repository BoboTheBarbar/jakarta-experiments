package com.colenio.jakartaeehelloworld2.control;

import com.colenio.jakartaeehelloworld2.entity.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class MessageProducer {
    @Produces
    public Message myMessage() {
        return new Message("Hello producer!");
    }
}
