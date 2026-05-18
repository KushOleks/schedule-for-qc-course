package com.softserve.mapper;

import com.softserve.dto.GroupDTO;
import com.softserve.dto.LessonForTeacherScheduleDTO;
import com.softserve.entity.Group;
import com.softserve.entity.Lesson;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class LessonForTeacherScheduleMapperImpl implements LessonForTeacherScheduleMapper {

    @Override
    public LessonForTeacherScheduleDTO lessonToLessonForTeacherScheduleDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonForTeacherScheduleDTO lessonForTeacherScheduleDTO = new LessonForTeacherScheduleDTO();

        lessonForTeacherScheduleDTO.setLessonType( lesson.getLessonType() );
        lessonForTeacherScheduleDTO.setGroup( groupToGroupDTO( lesson.getGroup() ) );
        lessonForTeacherScheduleDTO.setId( lesson.getId() );
        lessonForTeacherScheduleDTO.setLinkToMeeting( lesson.getLinkToMeeting() );
        lessonForTeacherScheduleDTO.setSubjectForSite( lesson.getSubjectForSite() );

        return lessonForTeacherScheduleDTO;
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
