package com.roms.authentication.service;

import com.roms.authentication.model.UserDetailPrincipal;
import com.roms.authentication.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roms.authentication.entity.User;
import com.roms.authentication.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    * Updating the logic of the user detail service, with our check of the username.
    * */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = userRepository.findByUsername(username);
        if (users.isEmpty()) {
            log.debug("Inside the exception thing");
            throw new UserNotFoundException(username);
        }
        return users.map(UserDetailPrincipal::new).get();
    }
}
