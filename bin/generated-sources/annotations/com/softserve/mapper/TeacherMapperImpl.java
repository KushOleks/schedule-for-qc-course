package com.softserve.mapper;

import com.softserve.dto.DepartmentDTO;
import com.softserve.dto.TeacherDTO;
import com.softserve.dto.TeacherForUpdateDTO;
import com.softserve.dto.TeacherImportDTO;
import com.softserve.dto.TeacherWithUserDTO;
import com.softserve.dto.UserDataDTO;
import com.softserve.entity.Department;
import com.softserve.entity.Teacher;
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
public class TeacherMapperImpl extends TeacherMapper {

    @Override
    public TeacherDTO teacherToTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setEmail( userIdToEmail( teacher.getUserId() ) );
        teacherDTO.setDepartmentDTO( departmentToDepartmentDTO( teacher.getDepartment() ) );
        teacherDTO.setDisable( teacher.isDisable() );
        teacherDTO.setId( teacher.getId() );
        teacherDTO.setName( teacher.getName() );
        teacherDTO.setPatronymic( teacher.getPatronymic() );
        teacherDTO.setPosition( teacher.getPosition() );
        teacherDTO.setSurname( teacher.getSurname() );

        return teacherDTO;
    }

    @Override
    public TeacherImportDTO teacherToTeacherImportDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherImportDTO teacherImportDTO = new TeacherImportDTO();

        teacherImportDTO.setEmail( userIdToEmail( teacher.getUserId() ) );
        teacherImportDTO.setDepartmentDTO( departmentToDepartmentDTO( teacher.getDepartment() ) );
        teacherImportDTO.setId( teacher.getId() );
        teacherImportDTO.setName( teacher.getName() );
        teacherImportDTO.setPatronymic( teacher.getPatronymic() );
        teacherImportDTO.setPosition( teacher.getPosition() );
        teacherImportDTO.setSurname( teacher.getSurname() );

        return teacherImportDTO;
    }

    @Override
    public Teacher teacherForUpdateDTOToTeacher(TeacherForUpdateDTO teacherForUpdateDTO) {
        if ( teacherForUpdateDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setDepartment( departmentDTOToDepartment( teacherForUpdateDTO.getDepartmentDTO() ) );
        teacher.setUserId( emailToUser( teacherForUpdateDTO.getEmail() ) );
        teacher.setDisable( teacherForUpdateDTO.isDisable() );
        teacher.setId( teacherForUpdateDTO.getId() );
        teacher.setName( teacherForUpdateDTO.getName() );
        teacher.setPatronymic( teacherForUpdateDTO.getPatronymic() );
        teacher.setPosition( teacherForUpdateDTO.getPosition() );
        teacher.setSurname( teacherForUpdateDTO.getSurname() );

        return teacher;
    }

    @Override
    public TeacherForUpdateDTO teacherToTeacherForUpdateDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherForUpdateDTO teacherForUpdateDTO = new TeacherForUpdateDTO();

        teacherForUpdateDTO.setEmail( userIdToEmail( teacher.getUserId() ) );
        teacherForUpdateDTO.setDepartmentDTO( departmentToDepartmentDTO( teacher.getDepartment() ) );
        teacherForUpdateDTO.setDisable( teacher.isDisable() );
        teacherForUpdateDTO.setId( teacher.getId() );
        teacherForUpdateDTO.setName( teacher.getName() );
        teacherForUpdateDTO.setPatronymic( teacher.getPatronymic() );
        teacherForUpdateDTO.setPosition( teacher.getPosition() );
        teacherForUpdateDTO.setSurname( teacher.getSurname() );

        return teacherForUpdateDTO;
    }

    @Override
    public Teacher teacherDTOToTeacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setDepartment( departmentDTOToDepartment( teacherDTO.getDepartmentDTO() ) );
        teacher.setUserId( emailToUser( teacherDTO.getEmail() ) );
        if ( teacherDTO.getDisable() != null ) {
            teacher.setDisable( teacherDTO.getDisable() );
        }
        teacher.setId( teacherDTO.getId() );
        teacher.setName( teacherDTO.getName() );
        teacher.setPatronymic( teacherDTO.getPatronymic() );
        teacher.setPosition( teacherDTO.getPosition() );
        teacher.setSurname( teacherDTO.getSurname() );

        return teacher;
    }

    @Override
    public Teacher teacherImportDTOToTeacher(TeacherImportDTO teacherImportDTO) {
        if ( teacherImportDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setDepartment( departmentDTOToDepartment( teacherImportDTO.getDepartmentDTO() ) );
        teacher.setUserId( emailToUser( teacherImportDTO.getEmail() ) );
        teacher.setId( teacherImportDTO.getId() );
        teacher.setName( teacherImportDTO.getName() );
        teacher.setPatronymic( teacherImportDTO.getPatronymic() );
        teacher.setPosition( teacherImportDTO.getPosition() );
        teacher.setSurname( teacherImportDTO.getSurname() );

        return teacher;
    }

    @Override
    public TeacherWithUserDTO toTeacherWithUserDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherWithUserDTO teacherWithUserDTO = new TeacherWithUserDTO();

        teacherWithUserDTO.setId( teacher.getId() );
        teacherWithUserDTO.setName( teacher.getName() );
        teacherWithUserDTO.setPatronymic( teacher.getPatronymic() );
        teacherWithUserDTO.setPosition( teacher.getPosition() );
        teacherWithUserDTO.setSurname( teacher.getSurname() );
        teacherWithUserDTO.setUserId( teacher.getUserId() );

        return teacherWithUserDTO;
    }

    @Override
    public UserDataDTO teacherToUserDataDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        UserDataDTO userDataDTO = new UserDataDTO();

        userDataDTO.setTeacherId( teacher.getId() );
        userDataDTO.setTeacherName( teacher.getName() );
        userDataDTO.setTeacherSurname( teacher.getSurname() );
        userDataDTO.setTeacherPatronymic( teacher.getPatronymic() );
        userDataDTO.setTeacherPosition( teacher.getPosition() );
        userDataDTO.setTeacherDepartmentDTO( departmentToDepartmentDTO( teacher.getDepartment() ) );

        return userDataDTO;
    }

    @Override
    public List<TeacherDTO> teachersToTeacherDTOs(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( teacherToTeacherDTO( teacher ) );
        }

        return list;
    }

    protected DepartmentDTO departmentToDepartmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO.DepartmentDTOBuilder departmentDTO = DepartmentDTO.builder();

        departmentDTO.disable( department.isDisable() );
        departmentDTO.id( department.getId() );
        departmentDTO.name( department.getName() );

        return departmentDTO.build();
    }

    protected Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDisable( departmentDTO.isDisable() );
        department.setId( departmentDTO.getId() );
        department.setName( departmentDTO.getName() );

        return department;
    }
}
