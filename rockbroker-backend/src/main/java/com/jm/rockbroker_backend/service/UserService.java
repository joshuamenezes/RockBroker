package com.jm.rockbroker_backend.service;

import com.jm.rockbroker_backend.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long userId, UserDTO updatedUserInfo);

    UserDTO getByUserName(String userName);

    UserDTO getUserByEmail(String email);
    Boolean validatePassword(String rawPassword, String encodedPassword);
}
