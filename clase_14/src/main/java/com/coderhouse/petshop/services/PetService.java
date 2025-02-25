package com.coderhouse.petshop.services;

import com.coderhouse.petshop.entities.Pet;
import com.coderhouse.petshop.entities.User;
import com.coderhouse.petshop.repositories.PetRepository;
import com.coderhouse.petshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Pet> findAll() {
    return petRepository.findAll();
  }

  public Pet findById(UUID id) {
    return petRepository.findById(id).orElse(null);
  }

  public Pet save(Pet pet) {
    return petRepository.save(pet);
  }

  public Pet adoptPet(UUID petId, UUID userId) {
    Optional<Pet> petDB = petRepository.findById(petId);
    Optional<User> userDB = userRepository.findById(userId);

    if (petDB.isEmpty() || userDB.isEmpty()) {
      return null;
    }

    Pet pet = petDB.get();

    if (pet.isAdopted()) {
      return null;
    }

    pet.setAdopted(true);
    pet.setAdoptedBy(userDB.get());

    return petRepository.save(pet);
  }
}
