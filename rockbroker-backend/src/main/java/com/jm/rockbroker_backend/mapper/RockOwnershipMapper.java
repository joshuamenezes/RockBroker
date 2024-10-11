package com.jm.rockbroker_backend.mapper;

import com.jm.rockbroker_backend.dto.RockOwnershipDTO;
import com.jm.rockbroker_backend.entity.RockOwnership;
import com.jm.rockbroker_backend.entity.User;

import java.util.Set;

public class RockOwnershipMapper {
    public static RockOwnershipDTO mapToRockOwnershipDto(RockOwnership rockOwnership) {
        return new RockOwnershipDTO(
                rockOwnership.getId(),
                RockMapper.mapToRockDto(rockOwnership.getRock()),
                rockOwnership.getQuantity()
        );
    };

    public static RockOwnership mapToRockOwnership(RockOwnershipDTO rockOwnershipDto, User user, Set<RockOwnership> rockOwnerships) {
        return new RockOwnership(
                rockOwnershipDto.getId(),
                user,
                RockMapper.mapToRock(rockOwnershipDto.getRock(), rockOwnerships),
                rockOwnershipDto.getQuantity()
        );
    }
}
