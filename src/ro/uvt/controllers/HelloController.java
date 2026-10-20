package ro.uvt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.difexamples.ClientComponent;

// record = clasa imutabila; Spring ii da ClientComponent prin constructor
@RestController
public record HelloController(ClientComponent clientComponent) {

    // pasul 9: http://localhost:8080
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    // pasul 10: http://localhost:8080/client
    @GetMapping("/client")
    public String helloClient() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}
