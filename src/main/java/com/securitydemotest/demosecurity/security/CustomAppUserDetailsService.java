package com.securitydemotest.demosecurity.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitydemotest.demosecurity.models.AppUser;
import com.securitydemotest.demosecurity.repositoryies.AppUserRepo;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CustomAppUserDetailsService implements UserDetailsService{
    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepo.findByName(username).orElseThrow(()->new UsernameNotFoundException(username+" not found"));
        UserDetails userDetails = new User(
                                            appUser.getName(), 
                                            appUser.getPassword(), 
                                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+appUser.getRole())) );

       return userDetails;
    }

    
}
