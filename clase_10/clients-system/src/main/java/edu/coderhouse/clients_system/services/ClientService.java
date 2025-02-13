package edu.coderhouse.clients_system.services;

import edu.coderhouse.clients_system.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final JdbcTemplate jdbc;

    public ClientService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void saveClient(Client client) {
        this.jdbc.update(
                "INSERT INTO client (name, email) VALUES (?, ?)",
                client.getName(),
                client.getEmail()
        );
    }

    public List<Client> getClients() {
        return this.jdbc.query(
                "SELECT * FROM client",
                (rs, rowNum) -> new Client(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                )
        );
    }
}
