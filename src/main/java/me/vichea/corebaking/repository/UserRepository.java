package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    User findByUsername(String username);

    Optional<User> findByEmail(String email);
}
