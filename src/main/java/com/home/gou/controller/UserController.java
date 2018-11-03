package com.home.gou.controller;

import com.home.gou.model.User;
import com.home.gou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping(value="/getAllUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping(value="authenticateUser")
    public boolean getIsUser(@RequestParam String userName, @RequestParam String userPassword){
        return userService.isUser(userName, userPassword);
    }


    @PostMapping(value="/addUser")
    public void addUser(@RequestBody User user
    ){
        userService.saveUser(user);
    }

    @GetMapping(value="/getUser")
    public User getUser(@RequestParam String userName, @RequestParam String userPassword){
        return userService.findUserbyUserName(userName,userPassword);
    }




}
