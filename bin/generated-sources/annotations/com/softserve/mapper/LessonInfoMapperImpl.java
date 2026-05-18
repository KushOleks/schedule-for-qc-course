package com.softserve.mapper;

import com.softserve.dto.GroupDTO;
import com.softserve.dto.LessonDTO;
import com.softserve.dto.LessonForGroupsDTO;
import com.softserve.dto.LessonInfoDTO;
import com.softserve.dto.LessonWithLinkDTO;
import com.softserve.dto.PeriodDTO;
import com.softserve.dto.SemesterDTO;
import com.softserve.dto.SubjectDTO;
import com.softserve.dto.TeacherNameDTO;
import com.softserve.entity.Group;
import com.softserve.entity.Lesson;
import com.softserve.entity.Period;
import com.softserve.entity.Semester;
import com.softserve.entity.Subject;
import com.softserve.entity.Teacher;
import com.softserve.entity.enums.LessonType;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class LessonInfoMapperImpl implements LessonInfoMapper {

    @Override
    public LessonInfoDTO lessonToLessonInfoDTO(Lesson lesson) {
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

    @Override
    public Lesson lessonInfoDTOToLesson(LessonInfoDTO lessonInfoDTO) {
        if ( lessonInfoDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setSemester( lessonInfoDTOToSemester( lessonInfoDTO ) );
        lesson.setGroup( groupDTOToGroup( lessonInfoDTO.getGroup() ) );
        lesson.setGrouped( lessonInfoDTO.isGrouped() );
        lesson.setHours( lessonInfoDTO.getHours() );
        lesson.setId( lessonInfoDTO.getId() );
        lesson.setLessonType( lessonInfoDTO.getLessonType() );
        lesson.setLinkToMeeting( lessonInfoDTO.getLinkToMeeting() );
        lesson.setSubject( subjectDTOToSubject( lessonInfoDTO.getSubject() ) );
        lesson.setSubjectForSite( lessonInfoDTO.getSubjectForSite() );
        lesson.setTeacher( teacherNameDTOToTeacher( lessonInfoDTO.getTeacher() ) );

        return lesson;
    }

    @Override
    public LessonDTO lessonToLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setSemesterId( lessonSemesterId( lesson ) );
        lessonDTO.setHours( lesson.getHours() );
        lessonDTO.setId( lesson.getId() );
        lessonDTO.setLessonType( lesson.getLessonType() );
        lessonDTO.setLinkToMeeting( lesson.getLinkToMeeting() );
        lessonDTO.setSubject( subjectToSubjectDTO( lesson.getSubject() ) );
        lessonDTO.setSubjectForSite( lesson.getSubjectForSite() );
        lessonDTO.setTeacher( teacherToTeacherNameDTO( lesson.getTeacher() ) );
        lessonDTO.setGroup( groupToGroupDTO( lesson.getGroup() ) );
        lessonDTO.setSemester( semesterToSemesterDTO( lesson.getSemester() ) );

        return lessonDTO;
    }

    @Override
    public Lesson lessonDTOToLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setGroup( groupDTOToGroup( lessonDTO.getGroup() ) );
        lesson.setHours( lessonDTO.getHours() );
        lesson.setId( lessonDTO.getId() );
        lesson.setLessonType( lessonDTO.getLessonType() );
        lesson.setLinkToMeeting( lessonDTO.getLinkToMeeting() );
        lesson.setSemester( semesterDTOToSemester( lessonDTO.getSemester() ) );
        lesson.setSubject( subjectDTOToSubject( lessonDTO.getSubject() ) );
        lesson.setSubjectForSite( lessonDTO.getSubjectForSite() );
        lesson.setTeacher( teacherNameDTOToTeacher( lessonDTO.getTeacher() ) );

        return lesson;
    }

    @Override
    public List<LessonInfoDTO> lessonsToLessonInfoDTOs(List<Lesson> lessons) {
        if ( lessons == null ) {
            return null;
        }

        List<LessonInfoDTO> list = new ArrayList<LessonInfoDTO>( lessons.size() );
        for ( Lesson lesson : lessons ) {
            list.add( lessonToLessonInfoDTO( lesson ) );
        }

        return list;
    }

    @Override
    public List<LessonDTO> lessonsToLessonDTOs(List<Lesson> lessons) {
        if ( lessons == null ) {
            return null;
        }

        List<LessonDTO> list = new ArrayList<LessonDTO>( lessons.size() );
        for ( Lesson lesson : lessons ) {
            list.add( lessonToLessonDTO( lesson ) );
        }

        return list;
    }

    @Override
    public LessonInfoDTO lessonForGroupsDTOToLessonInfoDTO(LessonForGroupsDTO lessonForGroupsDTO) {
        if ( lessonForGroupsDTO == null ) {
            return null;
        }

        LessonInfoDTO lessonInfoDTO = new LessonInfoDTO();

        lessonInfoDTO.setHours( lessonForGroupsDTO.getHours() );
        lessonInfoDTO.setId( lessonForGroupsDTO.getId() );
        lessonInfoDTO.setLessonType( lessonForGroupsDTO.getLessonType() );
        lessonInfoDTO.setLinkToMeeting( lessonForGroupsDTO.getLinkToMeeting() );
        lessonInfoDTO.setSemesterId( lessonForGroupsDTO.getSemesterId() );
        lessonInfoDTO.setSubject( lessonForGroupsDTO.getSubject() );
        lessonInfoDTO.setSubjectForSite( lessonForGroupsDTO.getSubjectForSite() );
        lessonInfoDTO.setTeacher( lessonForGroupsDTO.getTeacher() );
        lessonInfoDTO.setGrouped( lessonForGroupsDTO.isGrouped() );

        return lessonInfoDTO;
    }

    @Override
    public Lesson lessonWithLinkDTOToLesson(LessonWithLinkDTO lessonWithLinkDTO) {
        if ( lessonWithLinkDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setSemester( lessonWithLinkDTOToSemester( lessonWithLinkDTO ) );
        lesson.setTeacher( lessonWithLinkDTOToTeacher( lessonWithLinkDTO ) );
        lesson.setSubject( lessonWithLinkDTOToSubject( lessonWithLinkDTO ) );
        lesson.setLinkToMeeting( lessonWithLinkDTO.getLinkToMeeting() );
        if ( lessonWithLinkDTO.getLessonType() != null ) {
            lesson.setLessonType( Enum.valueOf( LessonType.class, lessonWithLinkDTO.getLessonType() ) );
        }

        return lesson;
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

    protected Semester lessonInfoDTOToSemester(LessonInfoDTO lessonInfoDTO) {
        if ( lessonInfoDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setId( lessonInfoDTO.getSemesterId() );

        return semester;
    }

    protected Group groupDTOToGroup(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group.GroupBuilder group = Group.builder();

        if ( groupDTO.getDisable() != null ) {
            group.disable( groupDTO.getDisable() );
        }
        group.id( groupDTO.getId() );
        group.title( groupDTO.getTitle() );

        return group.build();
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setDisable( subjectDTO.isDisable() );
        subject.setId( subjectDTO.getId() );
        subject.setName( subjectDTO.getName() );

        return subject;
    }

    protected Teacher teacherNameDTOToTeacher(TeacherNameDTO teacherNameDTO) {
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

    protected PeriodDTO periodToPeriodDTO(Period period) {
        if ( period == null ) {
            return null;
        }

        PeriodDTO periodDTO = new PeriodDTO();

        periodDTO.setEndTime( period.getEndTime() );
        periodDTO.setId( period.getId() );
        periodDTO.setName( period.getName() );
        periodDTO.setStartTime( period.getStartTime() );

        return periodDTO;
    }

    protected LinkedHashSet<PeriodDTO> periodSetToPeriodDTOLinkedHashSet(Set<Period> set) {
        if ( set == null ) {
            return null;
        }

        LinkedHashSet<PeriodDTO> linkedHashSet = new LinkedHashSet<PeriodDTO>();
        for ( Period period : set ) {
            linkedHashSet.add( periodToPeriodDTO( period ) );
        }

        return linkedHashSet;
    }

    protected SemesterDTO semesterToSemesterDTO(Semester semester) {
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
        semesterDTO.setPeriods( periodSetToPeriodDTOLinkedHashSet( semester.getPeriods() ) );
        semesterDTO.setStartDay( semester.getStartDay() );
        semesterDTO.setYear( semester.getYear() );

        return semesterDTO;
    }

    protected Period periodDTOToPeriod(PeriodDTO periodDTO) {
        if ( periodDTO == null ) {
            return null;
        }

        Period period = new Period();

        period.setEndTime( periodDTO.getEndTime() );
        period.setId( periodDTO.getId() );
        period.setName( periodDTO.getName() );
        period.setStartTime( periodDTO.getStartTime() );

        return period;
    }

    protected Set<Period> periodDTOLinkedHashSetToPeriodSet(LinkedHashSet<PeriodDTO> linkedHashSet) {
        if ( linkedHashSet == null ) {
            return null;
        }

        Set<Period> set = LinkedHashSet.newLinkedHashSet( linkedHashSet.size() );
        for ( PeriodDTO periodDTO : linkedHashSet ) {
            set.add( periodDTOToPeriod( periodDTO ) );
        }

        return set;
    }

    protected Semester semesterDTOToSemester(SemesterDTO semesterDTO) {
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

    protected Semester lessonWithLinkDTOToSemester(LessonWithLinkDTO lessonWithLinkDTO) {
        if ( lessonWithLinkDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setId( lessonWithLinkDTO.getSemesterId() );

        return semester;
    }

    protected Teacher lessonWithLinkDTOToTeacher(LessonWithLinkDTO lessonWithLinkDTO) {
        if ( lessonWithLinkDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( lessonWithLinkDTO.getTeacherId() );

        return teacher;
    }

    protected Subject lessonWithLinkDTOToSubject(LessonWithLinkDTO lessonWithLinkDTO) {
        if ( lessonWithLinkDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( lessonWithLinkDTO.getSubjectId() );

        return subject;
    }
}
