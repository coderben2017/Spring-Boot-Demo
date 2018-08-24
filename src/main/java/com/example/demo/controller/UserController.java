package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/{age}")
    public List<User> getUsersByAge(@PathVariable(value = "age") Integer age) {
        return userRepository.findByAge(age);
    }

    @GetMapping(value = "/user")
    public User getUserById(@RequestParam("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @PostMapping(value = "/user")
    public User addUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "gender") String gender,
                        @RequestParam(value = "age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        return userRepository.save(user);
    }

    @PutMapping(value = "/user")
    public User updateUser(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "gender") String gender,
                           @RequestParam(value = "age") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestParam(value = "id") Integer id) {
        userRepository.deleteById(id);
    }

}
