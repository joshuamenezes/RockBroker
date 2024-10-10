package com.jm.rockbroker_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class is used to transfer the Data between a client to a server (response from rest APIs)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RockDto {
    private Long id;
    private String name;
    private String ticker;
    private Double price;
}
