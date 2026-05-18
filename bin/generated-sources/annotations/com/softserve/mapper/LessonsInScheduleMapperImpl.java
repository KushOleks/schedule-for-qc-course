package com.softserve.mapper;

import com.softserve.dto.GroupDTO;
import com.softserve.dto.LessonInfoDTO;
import com.softserve.dto.LessonsInScheduleDTO;
import com.softserve.dto.SubjectDTO;
import com.softserve.dto.TeacherNameDTO;
import com.softserve.entity.Group;
import com.softserve.entity.Lesson;
import com.softserve.entity.Semester;
import com.softserve.entity.Subject;
import com.softserve.entity.Teacher;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class LessonsInScheduleMapperImpl implements LessonsInScheduleMapper {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public LessonsInScheduleDTO lessonToLessonsInScheduleDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonsInScheduleDTO lessonsInScheduleDTO = new LessonsInScheduleDTO();

        if ( lesson.getLessonType() != null ) {
            lessonsInScheduleDTO.setLessonType( lesson.getLessonType().name() );
        }
        lessonsInScheduleDTO.setLinkToMeeting( lesson.getLinkToMeeting() );
        lessonsInScheduleDTO.setSubjectForSite( lesson.getSubjectForSite() );
        lessonsInScheduleDTO.setTeacher( teacherMapper.teacherToTeacherDTO( lesson.getTeacher() ) );

        return lessonsInScheduleDTO;
    }

    @Override
    public LessonInfoDTO lessonToLessonsInTemporaryScheduleDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonInfoDTO lessonInfoDTO = new LessonInfoDTO();

        lessonInfoDTO.setSemesterId( lessonSemesterId( lesson ) );
        lessonInfoDTO.setHours( lesson.getHours() );
        lessonInfoDTO.setId( lesson.getId() );
        lessonInfoDTO.setLessonType( lesson.getLessonType() );
        lessonInfoDTO.setLinkToMeeting( lesson.getLinkToMeeting() );
        lessonInfoDTO.setSubject( subjectToSubjectDTO( lesson.getSubject() ) );
        lessonInfoDTO.setSubjectForSite( lesson.getSubjectForSite() );
        lessonInfoDTO.setTeacher( teacherToTeacherNameDTO( lesson.getTeacher() ) );
        lessonInfoDTO.setGroup( groupToGroupDTO( lesson.getGroup() ) );
        lessonInfoDTO.setGrouped( lesson.isGrouped() );

        return lessonInfoDTO;
    }

    private Long lessonSemesterId(Lesson lesson) {
        Semester semester = lesson.getSemester();
        if ( semester == null ) {
            return null;
        }
        return semester.getId();
    }

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setDisable( subject.isDisable() );
        subjectDTO.setId( subject.getId() );
        subjectDTO.setName( subject.getName() );

        return subjectDTO;
    }

    protected TeacherNameDTO teacherToTeacherNameDTO(Teacher teacher) {
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

    protected GroupDTO groupToGroupDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO.GroupDTOBuilder groupDTO = GroupDTO.builder();

        groupDTO.disable( group.isDisable() );
        groupDTO.id( group.getId() );
        groupDTO.title( group.getTitle() );

        return groupDTO.build();
    }
}
