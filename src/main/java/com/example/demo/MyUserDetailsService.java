package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		gaList.add(new SimpleGrantedAuthority("test"));
		UserDetailsImpl userDetails = new UserDetailsImpl("myuser", "{bcrypt}$2a$10$rxNZgdfVmo8BxeoCE5z0D.oCP/8zE1mVthscqpidYaR9A3SlS8su2", gaList);
        return userDetails;
    }
    
}
