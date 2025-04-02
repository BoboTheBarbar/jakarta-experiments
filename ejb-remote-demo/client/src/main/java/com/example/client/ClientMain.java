package com.example.client;

import com.example.ejb.HelloService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class ClientMain {
    public static void main(String[] args) throws NamingException {
        final Hashtable<String, String> jndiProps = new Hashtable<>();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "remote+http://localhost:8080");

        Context context = new InitialContext(jndiProps);

        HelloService helloService = (HelloService) context.lookup(
                "ejb:/ejb-impl-1.0-SNAPSHOT/HelloServiceBean!com.example.ejb.HelloService"
        );

        String result = helloService.sayHello("Team IntelliJ");
        System.out.println("Remote Response: " + result);
    }
}