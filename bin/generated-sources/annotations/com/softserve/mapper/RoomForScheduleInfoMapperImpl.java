package com.softserve.mapper;

import com.softserve.dto.RoomForScheduleInfoDTO;
import com.softserve.dto.RoomTypeDTO;
import com.softserve.entity.Room;
import com.softserve.entity.RoomType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class RoomForScheduleInfoMapperImpl implements RoomForScheduleInfoMapper {

    @Override
    public RoomForScheduleInfoDTO roomToRoomForScheduleInfoDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomForScheduleInfoDTO roomForScheduleInfoDTO = new RoomForScheduleInfoDTO();

        roomForScheduleInfoDTO.setId( room.getId() );
        roomForScheduleInfoDTO.setName( room.getName() );
        roomForScheduleInfoDTO.setType( roomTypeToRoomTypeDTO( room.getType() ) );

        return roomForScheduleInfoDTO;
    }

    @Override
    public List<RoomForScheduleInfoDTO> toRoomForScheduleDTOList(List<Room> room) {
        if ( room == null ) {
            return null;
        }

        List<RoomForScheduleInfoDTO> list = new ArrayList<RoomForScheduleInfoDTO>( room.size() );
        for ( Room room1 : room ) {
            list.add( roomToRoomForScheduleInfoDTO( room1 ) );
        }

        return list;
    }

    protected RoomTypeDTO roomTypeToRoomTypeDTO(RoomType roomType) {
        if ( roomType == null ) {
            return null;
        }

        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();

        roomTypeDTO.setDescription( roomType.getDescription() );
        roomTypeDTO.setId( roomType.getId() );

        return roomTypeDTO;
    }
}
