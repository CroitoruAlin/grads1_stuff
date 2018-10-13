package com.endava.springbootday3part5.controller;

import com.endava.springbootday3part5.model.Card;
import com.endava.springbootday3part5.model.CardDto;
import com.endava.springbootday3part5.model.User;
import com.endava.springbootday3part5.model.UserDetails;
import com.endava.springbootday3part5.proxy.CardServiceProxy;
import com.endava.springbootday3part5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/user/add")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }
    @GetMapping("/user/get/details/{username}")
    public UserDetails getUserDetails(@PathVariable("username") String username)
    {
        return userService.getUser(username);

    }
    @PostMapping("/user/add/card")
    public void addCard(@RequestBody CardDto cardDto)
    {
        userService.saveCard(cardDto);
    }
    @GetMapping("/user/get/card/{pan}")
    public Card getCard(@RequestParam String username,@PathVariable("pan") String pan)
    {
        return userService.getCard(username,pan);
    }
}
