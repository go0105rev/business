package com.example.todo.domain.service;

import jakarta.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.todo.app.mapper.AccountUserDetails;
import com.example.todo.domain.model.UserInf;
import com.example.todo.domain.repository.UserInfRepository;

@Service
@Transactional
public class AuthServiceImpl implements UserDetailsService {

    @Inject
    UserInfRepository userInf;

    @Override
    public UserDetails loadUserByUsername(
            String username) throws UsernameNotFoundException {

        try {

            UserInf userInf = this.userInf.findUser(username);
            if (userInf == null) {
                throw new ResourceNotFoundException("The given account is not found! username="
                        + username);
            }

            UserDetails account = new AccountUserDetails(userInf);
            return account;

        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException("user not found", e);
        }
    }
}
