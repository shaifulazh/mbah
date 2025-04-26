package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class MobileDetailsImpl extends User {

    public MobileDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        //TODO Auto-generated constructor stub
    }
    
}
