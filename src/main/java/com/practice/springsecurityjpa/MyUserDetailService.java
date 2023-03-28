package com.practice.springsecurityjpa;

import com.practice.springsecurityjpa.model.MyUserDetails;
import com.practice.springsecurityjpa.model.User;
import com.practice.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByusername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("No User found"));
        System.out.println(user.map(u -> new MyUserDetails(u)).get());
        return user.map(u -> new MyUserDetails(u)).get();
    }
}
