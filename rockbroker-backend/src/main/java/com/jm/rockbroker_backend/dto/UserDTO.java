package com.jm.rockbroker_backend.dto;

import lombok.*;

// The DTO (Data Transfer Object) decouples entities from the API or service layer.
// Important because we want to prevent exposing the internal db structure to the client.
// Oftentimes they are a subset of an entity.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
