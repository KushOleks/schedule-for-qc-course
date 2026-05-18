package com.softserve.mapper;

import com.softserve.dto.GroupDTO;
import com.softserve.dto.PeriodDTO;
import com.softserve.dto.SemesterDTO;
import com.softserve.dto.SemesterWithGroupsDTO;
import com.softserve.entity.Group;
import com.softserve.entity.Period;
import com.softserve.entity.Semester;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SemesterMapperImpl implements SemesterMapper {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private PeriodMapper periodMapper;

    @Override
    public SemesterDTO semesterToSemesterDTO(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterDTO semesterDTO = new SemesterDTO();

        semesterDTO.setCurrentSemester( semester.isCurrentSemester() );
        Set<DayOfWeek> set = semester.getDaysOfWeek();
        if ( set != null ) {
            semesterDTO.setDaysOfWeek( new TreeSet<DayOfWeek>( set ) );
        }
        semesterDTO.setDefaultSemester( semester.isDefaultSemester() );
        semesterDTO.setDescription( semester.getDescription() );
        semesterDTO.setDisable( semester.isDisable() );
        semesterDTO.setEndDay( semester.getEndDay() );
        semesterDTO.setId( semester.getId() );
        semesterDTO.setPeriods( periodMapper.periodsToLinkedHashSet( semester.getPeriods() ) );
        semesterDTO.setStartDay( semester.getStartDay() );
        semesterDTO.setYear( semester.getYear() );

        return semesterDTO;
    }

    @Override
    public Semester semesterDTOToSemester(SemesterDTO semesterDTO) {
        if ( semesterDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setCurrentSemester( semesterDTO.isCurrentSemester() );
        TreeSet<DayOfWeek> treeSet = semesterDTO.getDaysOfWeek();
        if ( treeSet != null ) {
            semester.setDaysOfWeek( new LinkedHashSet<DayOfWeek>( treeSet ) );
        }
        semester.setDefaultSemester( semesterDTO.isDefaultSemester() );
        semester.setDescription( semesterDTO.getDescription() );
        semester.setDisable( semesterDTO.isDisable() );
        semester.setEndDay( semesterDTO.getEndDay() );
        semester.setId( semesterDTO.getId() );
        semester.setPeriods( periodDTOLinkedHashSetToPeriodSet( semesterDTO.getPeriods() ) );
        semester.setStartDay( semesterDTO.getStartDay() );
        semester.setYear( semesterDTO.getYear() );

        return semester;
    }

    @Override
    public Semester semesterWithGroupsDTOToSemester(SemesterWithGroupsDTO semesterWithGroupsDTO) {
        if ( semesterWithGroupsDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setCurrentSemester( semesterWithGroupsDTO.isCurrentSemester() );
        TreeSet<DayOfWeek> treeSet = semesterWithGroupsDTO.getDaysOfWeek();
        if ( treeSet != null ) {
            semester.setDaysOfWeek( new LinkedHashSet<DayOfWeek>( treeSet ) );
        }
        semester.setDefaultSemester( semesterWithGroupsDTO.isDefaultSemester() );
        semester.setDescription( semesterWithGroupsDTO.getDescription() );
        semester.setDisable( semesterWithGroupsDTO.isDisable() );
        semester.setEndDay( semesterWithGroupsDTO.getEndDay() );
        semester.setGroups( groupDTOLinkedListToGroupSet( semesterWithGroupsDTO.getGroups() ) );
        semester.setId( semesterWithGroupsDTO.getId() );
        semester.setPeriods( periodDTOLinkedHashSetToPeriodSet( semesterWithGroupsDTO.getPeriods() ) );
        semester.setStartDay( semesterWithGroupsDTO.getStartDay() );
        semester.setYear( semesterWithGroupsDTO.getYear() );

        return semester;
    }

    @Override
    public List<SemesterDTO> semestersToSemesterDTOs(List<Semester> semesters) {
        if ( semesters == null ) {
            return null;
        }

        List<SemesterDTO> list = new ArrayList<SemesterDTO>( semesters.size() );
        for ( Semester semester : semesters ) {
            list.add( semesterToSemesterDTO( semester ) );
        }

        return list;
    }

    @Override
    public List<SemesterWithGroupsDTO> semestersToSemesterWithGroupsDTOs(List<Semester> semesters) {
        if ( semesters == null ) {
            return null;
        }

        List<SemesterWithGroupsDTO> list = new ArrayList<SemesterWithGroupsDTO>( semesters.size() );
        for ( Semester semester : semesters ) {
            list.add( semesterToSemesterWithGroupsDTO( semester ) );
        }

        return list;
    }

    @Override
    public SemesterWithGroupsDTO semesterToSemesterWithGroupsDTO(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterWithGroupsDTO semesterWithGroupsDTO = new SemesterWithGroupsDTO();

        semesterWithGroupsDTO.setCurrentSemester( semester.isCurrentSemester() );
        Set<DayOfWeek> set = semester.getDaysOfWeek();
        if ( set != null ) {
            semesterWithGroupsDTO.setDaysOfWeek( new TreeSet<DayOfWeek>( set ) );
        }
        semesterWithGroupsDTO.setDefaultSemester( semester.isDefaultSemester() );
        semesterWithGroupsDTO.setDescription( semester.getDescription() );
        semesterWithGroupsDTO.setDisable( semester.isDisable() );
        semesterWithGroupsDTO.setEndDay( semester.getEndDay() );
        semesterWithGroupsDTO.setId( semester.getId() );
        semesterWithGroupsDTO.setPeriods( periodMapper.periodsToLinkedHashSet( semester.getPeriods() ) );
        semesterWithGroupsDTO.setStartDay( semester.getStartDay() );
        semesterWithGroupsDTO.setYear( semester.getYear() );
        semesterWithGroupsDTO.setGroups( groupSetToGroupDTOLinkedList( semester.getGroups() ) );

        return semesterWithGroupsDTO;
    }

    protected Set<Period> periodDTOLinkedHashSetToPeriodSet(LinkedHashSet<PeriodDTO> linkedHashSet) {
        if ( linkedHashSet == null ) {
            return null;
        }

        Set<Period> set = LinkedHashSet.newLinkedHashSet( linkedHashSet.size() );
        for ( PeriodDTO periodDTO : linkedHashSet ) {
            set.add( periodMapper.convertToEntity( periodDTO ) );
        }

        return set;
    }

    protected Set<Group> groupDTOLinkedListToGroupSet(LinkedList<GroupDTO> linkedList) {
        if ( linkedList == null ) {
            return null;
        }

        Set<Group> set = LinkedHashSet.newLinkedHashSet( linkedList.size() );
        for ( GroupDTO groupDTO : linkedList ) {
            set.add( groupMapper.groupDTOToGroup( groupDTO ) );
        }

        return set;
    }

    protected LinkedList<GroupDTO> groupSetToGroupDTOLinkedList(Set<Group> set) {
        if ( set == null ) {
            return null;
        }

        LinkedList<GroupDTO> linkedList = new LinkedList<GroupDTO>();
        for ( Group group : set ) {
            linkedList.add( groupMapper.groupToGroupDTO( group ) );
        }

        return linkedList;
    }
}
