package com.example.main.controllers;

import com.example.main.entities.UserEntity;
import com.example.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserEntity[]> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserEntity> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
