package com.example.todo.app.mapper;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.todo.domain.model.UserInf;

public class AccountUserDetails implements UserDetails {

    private final UserInf userInf;

    private final Collection<GrantedAuthority> authorities;

    public AccountUserDetails(UserInf userInf) {
        this.userInf = userInf;
        this.authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getPassword() {
        return userInf.getPassword();
    }

    @Override
    public String getUsername() {
        return userInf.getUserId();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public UserInf getUserInf() {
        return userInf;
    }
}
