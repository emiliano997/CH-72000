package com.coderhouse.petshop.services;

import com.coderhouse.petshop.entities.User;
import com.coderhouse.petshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(UUID id) {
    return userRepository.findById(id).orElse(null);
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
