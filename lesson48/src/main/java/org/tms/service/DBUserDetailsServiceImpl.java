package org.tms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tms.domain.User;
import org.tms.dto.UserDto;
import org.tms.repository.UserRepository;

@RequiredArgsConstructor

@Service
public class DBUserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElse(null);
    }

    public void save(UserDto dto) {

        User user = new User();

        String username = dto.getUsername();
        String password = dto.getPassword();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setPermission("ROLE_USER");

        repository.save(user);
    }
}