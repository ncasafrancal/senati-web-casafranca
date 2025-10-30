package com.senati.senati_web_casafranca.service;

import com.senati.senati_web_casafranca.model.Response;
import com.senati.senati_web_casafranca.model.User;
import com.senati.senati_web_casafranca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<User> updateUser(int id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        User updateUser = new User();
        if (optionalUser.isPresent()){
            updateUser.setId(id);
            updateUser.setName(user.getName());
            updateUser.setLastname(user.getLastname());
        }

        return new ResponseEntity<>(userRepository.save(updateUser), HttpStatus.OK);
    }

    public Response deleteUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        Response response = new Response();

        if (optionalUser.isPresent()) {
            response.setMessage("El usuario con id: " + id + " se ha eliminado correctamente");
            userRepository.deleteById(id);
            return response;
        }

        response.setCode(404);
        response.setStatus("error");
        response.setMessage("No se puede eliminar el usuario");

        return response;
    }
}
