package com.softserve.mapper;

import com.softserve.dto.TeacherDTO;
import com.softserve.dto.TeacherNameDTO;
import com.softserve.entity.Teacher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class TeacherNameMapperImpl implements TeacherNameMapper {

    @Override
    public TeacherNameDTO teacherToTeacherNameDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherNameDTO teacherNameDTO = new TeacherNameDTO();

        teacherNameDTO.setId( teacher.getId() );
        teacherNameDTO.setName( teacher.getName() );
        teacherNameDTO.setPatronymic( teacher.getPatronymic() );
        teacherNameDTO.setSurname( teacher.getSurname() );

        return teacherNameDTO;
    }

    @Override
    public TeacherNameDTO teacherDTOToTeacherNameDTO(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        TeacherNameDTO teacherNameDTO = new TeacherNameDTO();

        teacherNameDTO.setId( teacherDTO.getId() );
        teacherNameDTO.setName( teacherDTO.getName() );
        teacherNameDTO.setPatronymic( teacherDTO.getPatronymic() );
        teacherNameDTO.setSurname( teacherDTO.getSurname() );

        return teacherNameDTO;
    }

    @Override
    public Teacher teacherNameDTOToTeacher(TeacherNameDTO teacherNameDTO) {
        if ( teacherNameDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherNameDTO.getId() );
        teacher.setName( teacherNameDTO.getName() );
        teacher.setPatronymic( teacherNameDTO.getPatronymic() );
        teacher.setSurname( teacherNameDTO.getSurname() );

        return teacher;
    }
}
