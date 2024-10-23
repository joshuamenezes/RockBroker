package com.jm.rockbroker_backend.controller;

import com.jm.rockbroker_backend.dto.UserDTO;
import com.jm.rockbroker_backend.entity.User;
import com.jm.rockbroker_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    // Define REST API using Spring Annotations. The request body annotation extracts the JSON from the payload and
    // converts it into a body

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser;
        savedUser = userService.createUser(userDTO);
        // TODO: Update the response type because we dont want to send the entire userDTO to the frontend
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
