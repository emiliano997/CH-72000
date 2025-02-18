package edu.coderhouse.clients_system.repositories;

import edu.coderhouse.clients_system.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { }
