package com.jm.rockbroker_backend.dto;

import lombok.*;

// This class is used to transfer the Data between a client to a server (response from rest APIs)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RockDTO {
    private Long id;
    private String name;
    private String ticker;
    private Double price;
}
