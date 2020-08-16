package com.marcusdacoregio.authserver.service;

import com.marcusdacoregio.authserver.domain.entity.Authorities;
import com.marcusdacoregio.authserver.domain.entity.AuthoritiesId;
import com.marcusdacoregio.authserver.domain.entity.User;
import com.marcusdacoregio.authserver.dto.NewUserDto;
import com.marcusdacoregio.authserver.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UserRepository userRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void createUser(NewUserDto newUser) {
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        addAuthorities(user);
        userRepository.save(user);
    }

    private void addAuthorities(User user) {
        Authorities authorities = new Authorities();
        authorities.setId(new AuthoritiesId(user));
        authorities.setAuthority("ROLE_USER");
        user.setAuthorities(Set.of(authorities));
    }
}
