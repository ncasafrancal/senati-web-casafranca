package com.senati.senati_web_casafranca.controller;

import com.senati.senati_web_casafranca.model.Response;
import com.senati.senati_web_casafranca.model.User;
import com.senati.senati_web_casafranca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({
        "http://localhost:4200/",
        "https://senati-web-casafranca-fe-c2fmexfrhmfgd2ff.chilecentral-01.azurewebsites.net"
})
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> newUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> newUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/api/user/{id}")
    public Response deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
    /*
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }*/

}
