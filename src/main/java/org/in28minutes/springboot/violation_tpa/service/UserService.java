package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    long countUsers();

    List<User> getAllUsers();

    Optional<User> findByUsername(String username);

    User saveUser(User user);
}
