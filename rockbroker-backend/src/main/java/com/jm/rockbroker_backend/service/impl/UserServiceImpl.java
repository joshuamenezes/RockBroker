package com.jm.rockbroker_backend.service.impl;

import com.jm.rockbroker_backend.dto.UserDTO;
import com.jm.rockbroker_backend.entity.User;
import com.jm.rockbroker_backend.exceptions.ResourceNotFoundException;
import com.jm.rockbroker_backend.mapper.UserMapper;
import com.jm.rockbroker_backend.repository.UserRepository;
import com.jm.rockbroker_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        // Encode the password using our encoder
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // Save the user
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No User exists with id %d.".formatted(userId)));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        // Intellij suggested that we can use the method reference to replace the lambda, but we also could have done (user) -> UserMapper.mapToUserDto(user)
        return users.stream().map((UserMapper::mapToUserDto)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUserInfo) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No User exists with id %d.".formatted(userId)));

        existingUser.setEmail(updatedUserInfo.getEmail());
        existingUser.setFirstName(updatedUserInfo.getFirstName());
        existingUser.setLastName(updatedUserInfo.getLastName());
        existingUser.setUserName(updatedUserInfo.getUserName());
        existingUser.setPassword(updatedUserInfo.getPassword());

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public UserDTO getByUserName(String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("No User exists with username %s.".formatted(userName)));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).
                orElseThrow(() -> new ResourceNotFoundException("No User exists with email %s.".formatted(email)));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public Boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
