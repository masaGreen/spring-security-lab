package com.securitydemotest.demosecurity.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitydemotest.demosecurity.dtos.LoginDTO;
import com.securitydemotest.demosecurity.dtos.UserDTO;
import com.securitydemotest.demosecurity.models.AppUser;
import com.securitydemotest.demosecurity.services.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reg")
public class AuthCOntroller {
    private final AppUserService appUserService;
    
    @PostMapping("/register")
    public AppUser register(@RequestBody UserDTO userDTO){
        return appUserService.saveUser(userDTO);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return appUserService.loginUser(loginDTO);
    }
}
