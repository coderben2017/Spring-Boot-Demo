package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(value = "/users")
    public void deleteTwo(@RequestParam(value = "ids") String ids) {
        String[] array = ids.split(",");
        Integer id1 = Integer.parseInt(array[0]);
        Integer id2 = Integer.parseInt(array[1]);
        userService.deleteTwo(id1, id2);
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
    public User addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
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
