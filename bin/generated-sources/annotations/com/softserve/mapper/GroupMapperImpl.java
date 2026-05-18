package com.softserve.mapper;

import com.softserve.dto.GroupDTO;
import com.softserve.dto.GroupDTOInRoomSchedule;
import com.softserve.dto.GroupWithStudentsDTO;
import com.softserve.entity.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDTO groupToGroupDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO.GroupDTOBuilder groupDTO = GroupDTO.builder();

        groupDTO.disable( group.isDisable() );
        if ( group.getId() != null ) {
            groupDTO.id( group.getId() );
        }
        if ( group.getTitle() != null ) {
            groupDTO.title( group.getTitle() );
        }

        return groupDTO.build();
    }

    @Override
    public Group groupDTOToGroup(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group.GroupBuilder group = Group.builder();

        if ( groupDTO.getDisable() != null ) {
            group.disable( groupDTO.getDisable() );
        }
        if ( groupDTO.getId() != null ) {
            group.id( groupDTO.getId() );
        }
        if ( groupDTO.getTitle() != null ) {
            group.title( groupDTO.getTitle() );
        }

        return group.build();
    }

    @Override
    public GroupWithStudentsDTO groupToGroupWithStudentsDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupWithStudentsDTO.GroupWithStudentsDTOBuilder groupWithStudentsDTO = GroupWithStudentsDTO.builder();

        if ( group.getId() != null ) {
            groupWithStudentsDTO.id( group.getId() );
        }
        if ( group.getTitle() != null ) {
            groupWithStudentsDTO.title( group.getTitle() );
        }

        return groupWithStudentsDTO.build();
    }

    @Override
    public List<GroupDTO> groupsToGroupDTOs(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( groupToGroupDTO( group ) );
        }

        return list;
    }

    @Override
    public List<GroupDTO> groupsToGroupDTOs(Collection<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( groupToGroupDTO( group ) );
        }

        return list;
    }

    @Override
    public GroupDTOInRoomSchedule groupToGroupDTOInRoomSchedule(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTOInRoomSchedule groupDTOInRoomSchedule = new GroupDTOInRoomSchedule();

        if ( group.getId() != null ) {
            groupDTOInRoomSchedule.setGroupId( group.getId() );
        }
        if ( group.getTitle() != null ) {
            groupDTOInRoomSchedule.setGroupName( group.getTitle() );
        }

        return groupDTOInRoomSchedule;
    }

    @Override
    public List<GroupDTOInRoomSchedule> toGroupDTOInRoomSchedule(List<Group> group) {
        if ( group == null ) {
            return null;
        }

        List<GroupDTOInRoomSchedule> list = new ArrayList<GroupDTOInRoomSchedule>( group.size() );
        for ( Group group1 : group ) {
            list.add( groupToGroupDTOInRoomSchedule( group1 ) );
        }

        return list;
    }
}
