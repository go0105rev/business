package com.example.todo.domain.service;

import jakarta.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.domain.model.UserInf;
import com.example.todo.domain.repository.UserInfRepository;

@Service
@Transactional
public class UserManageServiceImpl {
    
    @Inject
    UserInfRepository userInf;
    
    @Inject
    PasswordEncoder passwordEncoder;
    
    public void register(UserInf userInf, String pass) {
        
        String password = passwordEncoder.encode(pass);
        userInf.setPassword(password);

        this.userInf.create(userInf);
        
    }

}
