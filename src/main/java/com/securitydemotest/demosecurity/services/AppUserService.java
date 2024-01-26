package com.securitydemotest.demosecurity.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitydemotest.demosecurity.dtos.LoginDTO;
import com.securitydemotest.demosecurity.dtos.UserDTO;
import com.securitydemotest.demosecurity.models.AppUser;
import com.securitydemotest.demosecurity.repositoryies.AppUserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepo appUserRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    
    public AppUser saveUser(UserDTO userDTO){
        //check if exists
        AppUser appUser = new AppUser();
        appUser.setName(userDTO.name());
        appUser.setPassword(passwordEncoder.encode(userDTO.password()));
        return appUserRepo.save(appUser);
    }

    public String loginUser(LoginDTO loginDTO){
        
        //make a usernamepasswordauthtoken s of type authntication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
        new UsernamePasswordAuthenticationToken(loginDTO.name(), loginDTO.password());

        try {
            //pass it auth manager
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            //set the authentication to context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return String.format("login successfule for %s", loginDTO.name());
        } catch (Exception e) {
            throw new BadCredentialsException("password or email are wrong");
         
        }
    }
}
