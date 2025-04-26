package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MobileDetailsService implements  UserDetailsService {

    @Autowired 
    private MobileRepository mobileRepository;

    @Override
    public UserDetails loadUserByUsername(String deviceName) throws UsernameNotFoundException {
               		Mobile mobile = mobileRepository.findBydeviceName(deviceName)
				.orElseThrow(() -> new UsernameNotFoundException("mobile Not Found with deviname: " + deviceName));
		List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		gaList.add(new SimpleGrantedAuthority("ADMIN"));
		MobileDetailsImpl mobileDetailsImpl = new MobileDetailsImpl(mobile.getdeviceName(), mobile.getPassword(), gaList);
		return mobileDetailsImpl;
    }
    
}
