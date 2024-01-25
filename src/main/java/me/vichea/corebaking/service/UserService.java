package me.vichea.corebaking.service;

import me.vichea.corebaking.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {

    Optional<User> findById(Long id);

    User signUp(User user);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    User findByUsername(String username);

    User save(User user);

    List<User> findAll();

    UserDetailsService userDetailsService();
}

