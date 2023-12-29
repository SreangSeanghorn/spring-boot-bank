package me.vichea.corebaking.controller;

import me.vichea.corebaking.dto.BankResponse;
import me.vichea.corebaking.dto.UserRequest;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }
    @PostMapping("/login")
    public BankResponse login(@RequestBody UserRequest userRequest){
        return userService.login(userRequest);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
