package com.coderhouse.petshop.repositories;

import com.coderhouse.petshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { }
