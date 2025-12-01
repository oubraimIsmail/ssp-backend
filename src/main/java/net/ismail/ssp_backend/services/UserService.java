package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    User findParentByEmail(String email);
    List<User> findParentByName(String name);
}
