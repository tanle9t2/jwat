package com.jwat.jwat_assgiment.jwat_assgiment.service.impl;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.User;
import com.jwat.jwat_assgiment.jwat_assgiment.exception.ResourceNotFoundExeption;
import com.jwat.jwat_assgiment.jwat_assgiment.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(usernameOrEmail).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        if (user == null) {
            throw new Error("user not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
