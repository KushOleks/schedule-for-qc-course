package com.softserve.mapper;

import com.softserve.dto.RoomTypeDTO;
import com.softserve.entity.RoomType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:33+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class RoomTypeMapperImpl implements RoomTypeMapper {

    @Override
    public RoomTypeDTO roomTypeToRoomTypeDTO(RoomType roomType) {
        if ( roomType == null ) {
            return null;
        }

        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();

        roomTypeDTO.setDescription( roomType.getDescription() );
        roomTypeDTO.setId( roomType.getId() );

        return roomTypeDTO;
    }

    @Override
    public RoomType roomTypeDTOTRoomType(RoomTypeDTO roomTypeDTO) {
        if ( roomTypeDTO == null ) {
            return null;
        }

        RoomType roomType = new RoomType();

        roomType.setDescription( roomTypeDTO.getDescription() );
        roomType.setId( roomTypeDTO.getId() );

        return roomType;
    }

    @Override
    public List<RoomTypeDTO> roomTypesToRoomTypeDTOs(List<RoomType> roomTypes) {
        if ( roomTypes == null ) {
            return null;
        }

        List<RoomTypeDTO> list = new ArrayList<RoomTypeDTO>( roomTypes.size() );
        for ( RoomType roomType : roomTypes ) {
            list.add( roomTypeToRoomTypeDTO( roomType ) );
        }

        return list;
    }
}
