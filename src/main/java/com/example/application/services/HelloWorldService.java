package com.example.application.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@BrowserCallable
@PermitAll
@Service
public class HelloWorldService {

    public String sayHello(String name) {
        if (name.isEmpty()) {
            return "Hello stranger";
        } else {
            return "Hello " + name;
        }
    }

    @RolesAllowed("USER")
    public Flux<String> myFlux() {
        return Flux.just("Hello", "World", "from", "Flux!");
    }
}
