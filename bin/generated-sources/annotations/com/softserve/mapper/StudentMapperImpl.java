package com.softserve.mapper;

import com.softserve.dto.StudentDTO;
import com.softserve.dto.StudentImportDTO;
import com.softserve.dto.StudentWithoutGroupDTO;
import com.softserve.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl extends StudentMapper {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.email( userToEmail( student.getUser() ) );
        studentDTO.group( groupMapper.groupToGroupDTO( student.getGroup() ) );
        studentDTO.id( student.getId() );
        studentDTO.name( student.getName() );
        studentDTO.patronymic( student.getPatronymic() );
        studentDTO.surname( student.getSurname() );

        return studentDTO.build();
    }

    @Override
    public StudentImportDTO studentToStudentImportDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentImportDTO studentImportDTO = new StudentImportDTO();

        studentImportDTO.setEmail( userToEmail( student.getUser() ) );
        studentImportDTO.setGroupDTO( groupMapper.groupToGroupDTO( student.getGroup() ) );
        studentImportDTO.setId( student.getId() );
        studentImportDTO.setName( student.getName() );
        studentImportDTO.setPatronymic( student.getPatronymic() );
        studentImportDTO.setSurname( student.getSurname() );

        return studentImportDTO;
    }

    @Override
    public Student studentImportDTOToStudent(StudentImportDTO studentImportDTO) {
        if ( studentImportDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setUser( emailToUser( studentImportDTO.getEmail() ) );
        student.setGroup( groupMapper.groupDTOToGroup( studentImportDTO.getGroupDTO() ) );
        student.setId( studentImportDTO.getId() );
        student.setName( studentImportDTO.getName() );
        student.setPatronymic( studentImportDTO.getPatronymic() );
        student.setSurname( studentImportDTO.getSurname() );

        return student;
    }

    @Override
    public Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setUser( emailToUser( studentDTO.getEmail() ) );
        student.setGroup( groupMapper.groupDTOToGroup( studentDTO.getGroup() ) );
        student.setId( studentDTO.getId() );
        student.setName( studentDTO.getName() );
        student.setPatronymic( studentDTO.getPatronymic() );
        student.setSurname( studentDTO.getSurname() );

        return student;
    }

    @Override
    public StudentWithoutGroupDTO studentToStudentWithoutGroupDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentWithoutGroupDTO.StudentWithoutGroupDTOBuilder studentWithoutGroupDTO = StudentWithoutGroupDTO.builder();

        studentWithoutGroupDTO.email( userToEmail( student.getUser() ) );
        studentWithoutGroupDTO.id( student.getId() );
        studentWithoutGroupDTO.name( student.getName() );
        studentWithoutGroupDTO.patronymic( student.getPatronymic() );
        studentWithoutGroupDTO.surname( student.getSurname() );

        return studentWithoutGroupDTO.build();
    }

    @Override
    public Student studentWithoutGroupDTOToStudent(StudentWithoutGroupDTO studentWithoutGroupDTO) {
        if ( studentWithoutGroupDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setUser( emailToUser( studentWithoutGroupDTO.getEmail() ) );
        student.setId( studentWithoutGroupDTO.getId() );
        student.setName( studentWithoutGroupDTO.getName() );
        student.setPatronymic( studentWithoutGroupDTO.getPatronymic() );
        student.setSurname( studentWithoutGroupDTO.getSurname() );

        return student;
    }

    @Override
    public List<StudentDTO> convertToDTOList(List<Student> studentList) {
        if ( studentList == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( studentList.size() );
        for ( Student student : studentList ) {
            list.add( studentToStudentDTO( student ) );
        }

        return list;
    }
}
