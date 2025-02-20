package com.example.main.services;

import com.example.main.api.UserRestApi;
import com.example.main.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRestApi userRestApi;

    public ResponseEntity<UserEntity[]> getUsers() {
        return userRestApi.getUsers();
    }

    public UserEntity getUser(int id) {
        return userRestApi.getUser(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRestApi.saveUser(user);
    }

    public UserEntity updateUser(int id, UserEntity user) {
        return userRestApi.updateUser(id, user);
    }

    public UserEntity deleteUser(int id) {
        return userRestApi.deleteUser(id);
    }
}
