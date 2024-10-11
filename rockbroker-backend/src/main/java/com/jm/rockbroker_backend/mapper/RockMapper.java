package com.jm.rockbroker_backend.mapper;

import com.jm.rockbroker_backend.dto.RockDTO;
import com.jm.rockbroker_backend.entity.Rock;
import com.jm.rockbroker_backend.entity.RockOwnership;

import java.util.Set;

public class RockMapper {
    public static RockDTO mapToRockDto(Rock rock) {
        return new RockDTO(
                rock.getId(),
                rock.getName(),
                rock.getTicker(),
                rock.getPrice()
        );
    }

    public static Rock mapToRock(RockDTO rockDto, Set<RockOwnership> rockOwnerships) {
        return new Rock(
                rockDto.getId(),
                rockDto.getName(),
                rockDto.getTicker(),
                rockDto.getPrice(),
                rockOwnerships
        );
    }
}
