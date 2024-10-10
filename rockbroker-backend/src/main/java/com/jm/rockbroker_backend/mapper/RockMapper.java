package com.jm.rockbroker_backend.mapper;

import com.jm.rockbroker_backend.dto.RockDto;
import com.jm.rockbroker_backend.entity.Rock;

public class RockMapper {
    public static RockDto mapToRockDto(Rock rock) {
        return new RockDto(
                rock.getId(),
                rock.getName(),
                rock.getTicker(),
                rock.getPrice()
        );
    }

    public static Rock mapToRock(RockDto rockDto) {
        return new Rock(
                rockDto.getId(),
                rockDto.getName(),
                rockDto.getTicker(),
                rockDto.getPrice()
        );
    }
}
