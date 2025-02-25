package com.coderhouse.petshop.repositories;

import com.coderhouse.petshop.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> { }
