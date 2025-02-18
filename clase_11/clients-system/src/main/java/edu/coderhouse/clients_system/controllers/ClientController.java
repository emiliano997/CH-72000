package edu.coderhouse.clients_system.controllers;

import edu.coderhouse.clients_system.entities.Client;
import edu.coderhouse.clients_system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        // Response.ok -> Status Code 200
        return ResponseEntity.ok(this.clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClient(@PathVariable Long id) {
        Optional<Client> client = this.clientService.getClient(id);

        if(client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        try {
            this.clientService.saveClient(client);
            return ResponseEntity.ok(client);
        } catch (Error error) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Optional<Client>> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client> newClient = this.clientService.updateClient(id, client);

        if (newClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(newClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Client>> deleteClient(@PathVariable Long id) {
        Optional<Client> client = this.clientService.deleteClient(id);

        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }
}
