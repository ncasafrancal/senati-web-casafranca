package com.senati.senati_web_casafranca.service;

import com.senati.senati_web_casafranca.model.User;
import com.senati.senati_web_casafranca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> newUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }
}
