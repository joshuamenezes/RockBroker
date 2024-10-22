package com.jm.rockbroker_backend.mapper;

import com.jm.rockbroker_backend.dto.UserDTO;
import com.jm.rockbroker_backend.entity.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO mapToUserDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDTO userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword(),
                null // Rock ownerships will be set later if needed
        );
    }
}
