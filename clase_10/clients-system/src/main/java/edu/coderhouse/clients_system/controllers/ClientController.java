package edu.coderhouse.clients_system.controllers;

import edu.coderhouse.clients_system.entities.Client;
import edu.coderhouse.clients_system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        // Response.ok -> Status Code 200
        return ResponseEntity.ok(this.clientService.getClients());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        this.clientService.saveClient(client);
        return ResponseEntity.ok(client);
    }
}
