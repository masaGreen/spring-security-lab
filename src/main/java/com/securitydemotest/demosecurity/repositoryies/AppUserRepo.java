package com.securitydemotest.demosecurity.repositoryies;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitydemotest.demosecurity.models.AppUser;


public interface AppUserRepo extends JpaRepository<AppUser, Integer>{

    Optional<AppUser> findByName(String username);
    
}
