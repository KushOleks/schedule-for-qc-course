package com.softserve.mapper;

import com.softserve.dto.RoomDTO;
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
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room convertToEntity(RoomDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Room room = new Room();

        room.setDisable( dto.isDisable() );
        room.setId( dto.getId() );
        room.setName( dto.getName() );
        room.setType( roomTypeDTOToRoomType( dto.getType() ) );

        return room;
    }

    @Override
    public RoomDTO convertToDto(Room entity) {
        if ( entity == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setDisable( entity.isDisable() );
        roomDTO.setId( entity.getId() );
        roomDTO.setName( entity.getName() );
        roomDTO.setType( roomTypeToRoomTypeDTO( entity.getType() ) );

        return roomDTO;
    }

    @Override
    public List<RoomDTO> convertToDtoList(List<Room> rooms) {
        if ( rooms == null ) {
            return null;
        }

        List<RoomDTO> list = new ArrayList<RoomDTO>( rooms.size() );
        for ( Room room : rooms ) {
            list.add( convertToDto( room ) );
        }

        return list;
    }

    protected RoomType roomTypeDTOToRoomType(RoomTypeDTO roomTypeDTO) {
        if ( roomTypeDTO == null ) {
            return null;
        }

        RoomType roomType = new RoomType();

        roomType.setDescription( roomTypeDTO.getDescription() );
        roomType.setId( roomTypeDTO.getId() );

        return roomType;
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
