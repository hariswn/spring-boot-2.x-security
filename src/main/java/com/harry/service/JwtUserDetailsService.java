package com.harry.service;

import java.util.ArrayList;
import java.util.Optional;

import com.harry.model.UserModel;
import com.harry.repository.InstagramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private InstagramUserRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional< UserModel> optionalUserModel = this.repository.findByUserName(username);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            return new User(userModel.getUserName(), userModel.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserModel save(UserModel user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

}
