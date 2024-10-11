package com.jm.rockbroker_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RockOwnershipDTO {
    private Long id;
    private RockDTO rock;
    private Integer quantity;
}
