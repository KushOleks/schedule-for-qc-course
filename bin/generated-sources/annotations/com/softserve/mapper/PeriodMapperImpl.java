package com.softserve.mapper;

import com.softserve.dto.AddPeriodDTO;
import com.softserve.dto.PeriodDTO;
import com.softserve.entity.Period;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class PeriodMapperImpl implements PeriodMapper {

    @Override
    public Period convertToEntity(AddPeriodDTO addPeriodDTO) {
        if ( addPeriodDTO == null ) {
            return null;
        }

        Period period = new Period();

        period.setEndTime( addPeriodDTO.getEndTime() );
        period.setName( addPeriodDTO.getName() );
        period.setStartTime( addPeriodDTO.getStartTime() );

        return period;
    }

    @Override
    public PeriodDTO convertToDto(Period entity) {
        if ( entity == null ) {
            return null;
        }

        PeriodDTO periodDTO = new PeriodDTO();

        periodDTO.setEndTime( entity.getEndTime() );
        periodDTO.setId( entity.getId() );
        periodDTO.setName( entity.getName() );
        periodDTO.setStartTime( entity.getStartTime() );

        return periodDTO;
    }

    @Override
    public Period convertToEntity(PeriodDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Period period = new Period();

        period.setEndTime( dto.getEndTime() );
        period.setId( dto.getId() );
        period.setName( dto.getName() );
        period.setStartTime( dto.getStartTime() );

        return period;
    }

    @Override
    public List<PeriodDTO> convertToDtoList(List<Period> periods) {
        if ( periods == null ) {
            return null;
        }

        List<PeriodDTO> list = new ArrayList<PeriodDTO>( periods.size() );
        for ( Period period : periods ) {
            list.add( convertToDto( period ) );
        }

        return list;
    }

    @Override
    public List<Period> convertToEntityList(List<AddPeriodDTO> periods) {
        if ( periods == null ) {
            return null;
        }

        List<Period> list = new ArrayList<Period>( periods.size() );
        for ( AddPeriodDTO addPeriodDTO : periods ) {
            list.add( convertToEntity( addPeriodDTO ) );
        }

        return list;
    }

    @Override
    public LinkedHashSet<PeriodDTO> periodsToLinkedHashSet(Set<Period> periods) {
        if ( periods == null ) {
            return null;
        }

        LinkedHashSet<PeriodDTO> linkedHashSet = new LinkedHashSet<PeriodDTO>();
        for ( Period period : periods ) {
            linkedHashSet.add( convertToDto( period ) );
        }

        return linkedHashSet;
    }
}
