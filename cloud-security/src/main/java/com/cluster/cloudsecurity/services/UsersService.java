package com.cluster.cloudsecurity.services;

import com.cluster.cloudsecurity.dao.AppUserRepository;
import com.cluster.cloudsecurity.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersService implements UserDetailsService {
    private AppUserRepository appUserRepository;
    public UsersService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        implement a call to the user_service
        AppUser au = appUserRepository.findAppUserByName(name);
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
        SimpleGrantedAuthority user = new SimpleGrantedAuthority("USER");
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(admin);
        authorities.add(user);
        return new User(au.getName(), au.getPassword(), authorities);
    }
}
