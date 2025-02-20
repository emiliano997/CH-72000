package com.example.main.api;

import com.example.main.entities.UserEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRestApi {

    final String uri = "https://jsonplaceholder.typicode.com/users";

    public ResponseEntity<UserEntity[]> getUsers() {
        RestTemplate restTemplate = new RestTemplate();

//        ResponseEntity<UserEntity[]> response = restTemplate.exchange(
//                uri,
//                HttpMethod.GET,
//                null,
//                UserEntity[].class
//        );

        return restTemplate.getForEntity(uri, UserEntity[].class);
    }

    public UserEntity getUser(int id) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        UserEntity userEntity = restTemplate.getForObject(
                uri + "/{id}",
                UserEntity.class,
                params
        );

        return userEntity;
    }

    public UserEntity saveUser(UserEntity user) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(
                uri,
                user,
                UserEntity.class
        );
    }

    public UserEntity updateUser(int id, UserEntity user) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        restTemplate.put(
                uri + "/{id}",
                user,
                params
        );

        return user;
    }

    public UserEntity deleteUser(int id) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        UserEntity userEntity = restTemplate.getForObject(
                uri + "/{id}",
                UserEntity.class,
                params
        );

        restTemplate.delete(
                uri + "/{id}",
                params
        );

        return userEntity;
    }
}
