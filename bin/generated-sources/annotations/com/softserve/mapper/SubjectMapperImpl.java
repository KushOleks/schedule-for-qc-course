package com.softserve.mapper;

import com.softserve.dto.SubjectDTO;
import com.softserve.entity.Subject;
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
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setDisable( subject.isDisable() );
        subjectDTO.setId( subject.getId() );
        subjectDTO.setName( subject.getName() );

        return subjectDTO;
    }

    @Override
    public Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setDisable( subjectDTO.isDisable() );
        subject.setId( subjectDTO.getId() );
        subject.setName( subjectDTO.getName() );

        return subject;
    }

    @Override
    public List<SubjectDTO> subjectsToSubjectDTOs(List<Subject> subjects) {
        if ( subjects == null ) {
            return null;
        }

        List<SubjectDTO> list = new ArrayList<SubjectDTO>( subjects.size() );
        for ( Subject subject : subjects ) {
            list.add( subjectToSubjectDTO( subject ) );
        }

        return list;
    }
}
