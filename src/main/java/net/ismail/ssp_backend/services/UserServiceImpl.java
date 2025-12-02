package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.UserDTO;
import net.ismail.ssp_backend.entities.User;
import net.ismail.ssp_backend.mappers.UserMapper;
import net.ismail.ssp_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        // Vérifier email unique
        if (userRepository.findByNameContainingIgnoreCase(userDTO.getEmail()) != null) {
            throw new RuntimeException("Email already exists!");
        }

        // Convert DTO → Entity
        User user = userMapper.toEntity(userDTO);

        // TODO: passwordEncoder (optionnel)
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saved = userRepository.save(user);

        // Retourner DTO
        return userMapper.toDTO(saved);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update entity depuis DTO (mapper custom)
        User updated = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDTO(updated);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findParentByEmail(String email) {
        User user = userRepository.findByEmailContains(email);
        if (user == null) throw new RuntimeException("Parent not found");
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findParentByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}
