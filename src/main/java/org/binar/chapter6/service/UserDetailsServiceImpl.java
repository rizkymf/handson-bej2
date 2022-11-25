package org.binar.chapter6.service;

import org.binar.chapter6.model.UserDetailsImpl;
import org.binar.chapter6.model.Users;
import org.binar.chapter6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username).orElseGet(null);
        // do something
        return UserDetailsImpl.build(user);
    }

//    public UserDetails loadUserByEmail(String email){
//        Users user = usersRepository.findByEmail(email);
//        return UserDetailsImpl.build(user);
//    }

}
