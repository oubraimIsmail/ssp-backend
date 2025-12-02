package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.dtos.UserDTO;
import net.ismail.ssp_backend.entities.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO findParentByEmail(String email);
    List<UserDTO> findParentByName(String name);
}
