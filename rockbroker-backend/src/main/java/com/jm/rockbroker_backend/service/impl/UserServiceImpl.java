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
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public Boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
