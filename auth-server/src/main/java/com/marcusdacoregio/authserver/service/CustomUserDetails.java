package com.marcusdacoregio.authserver.service;

import com.marcusdacoregio.authserver.domain.entity.User;
import com.marcusdacoregio.authserver.persistence.repository.UserRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserDetailsChecker userDetailsChecker;

    public CustomUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userDetailsChecker = new AccountStatusUserDetailsChecker();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        userDetailsChecker.check(user);
        return user;
    }
}
