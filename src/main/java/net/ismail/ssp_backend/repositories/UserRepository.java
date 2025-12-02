package net.ismail.ssp_backend.repositories;

import net.ismail.ssp_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailContains(String email);

    List<User> findByNameContainingIgnoreCase(String name);
}
