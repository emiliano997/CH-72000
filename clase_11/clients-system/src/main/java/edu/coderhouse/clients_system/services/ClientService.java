package edu.coderhouse.clients_system.services;

import edu.coderhouse.clients_system.entities.Client;
import edu.coderhouse.clients_system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client) {
        this.clientRepository.save(client);
    }

    public Optional<Client> getClient(Long id) {
        return this.clientRepository.findById(id);
    }

    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }

    public Optional<Client> updateClient(Long id, Client client) {
        Optional<Client> clientDB = this.clientRepository.findById(id);

       if(clientDB.isEmpty()) {
           return Optional.empty();
       }

       clientDB.get().setName(client.getName());
       clientDB.get().setEmail(client.getEmail());

       this.clientRepository.save(clientDB.get());

       return clientDB;
    }

    public Optional<Client> deleteClient(Long id) {
        Optional<Client> clientDB = this.clientRepository.findById(id);

        if(clientDB.isEmpty()) {
            return Optional.empty();
        }

        this.clientRepository.deleteById(id);

        return clientDB;
    }
}
