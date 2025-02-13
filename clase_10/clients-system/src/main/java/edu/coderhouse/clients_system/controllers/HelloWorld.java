package edu.coderhouse.clients_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {

    // Endpoint
    // Definición de la ruta para acceder a este metodo
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
