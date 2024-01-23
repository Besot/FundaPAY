package com.besot.fundapay.controller;

import com.besot.fundapay.dto.BankResponse;
import com.besot.fundapay.dto.UserRequest;
import com.besot.fundapay.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

//create account
@Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/create_account")
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
    return userService.createUserAccount(userRequest);
    }
}
