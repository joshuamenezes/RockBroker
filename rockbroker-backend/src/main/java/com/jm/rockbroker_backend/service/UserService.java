package com.jm.rockbroker_backend.service;

import com.jm.rockbroker_backend.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);

    UserDTO getByUserName(String userName);

    UserDTO getUserByEmail(String email);
    Boolean validatePassword(String rawPassword, String encodedPassword);
}
