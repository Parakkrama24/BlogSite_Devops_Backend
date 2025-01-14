package com.devops.BlogSite.service;

import com.devops.BlogSite.domain.USER_ROLE;
import com.devops.BlogSite.model.user;
import org.springframework.aop.aspectj.InstantiationModelAwarePointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import com.devops.BlogSite.repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceImplementation implements UserDetailsService {

    @Autowired
    private userRepository userRepository;

    public CustomUserServiceImplementation(userRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        user user = userRepository.findUserByEmail(username);

        if(user==null) {

            throw new UsernameNotFoundException("user not found with email  - "+username);
        }

        USER_ROLE role=user.getRole();

        if(role==null) role=USER_ROLE.ROLE_READER;

        System.out.println("role  ---- "+role);

        List<GrantedAuthority> authorities=new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.toString()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),user.getPassword(),authorities);
    }
}
