package com.softserve.mapper;

import com.softserve.dto.RoomForScheduleDTO;
import com.softserve.entity.Room;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class RoomForScheduleMapperImpl implements RoomForScheduleMapper {

    @Override
    public RoomForScheduleDTO roomToRoomForScheduleDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomForScheduleDTO roomForScheduleDTO = new RoomForScheduleDTO();

        roomForScheduleDTO.setId( room.getId() );
        roomForScheduleDTO.setName( room.getName() );

        return roomForScheduleDTO;
    }
}
