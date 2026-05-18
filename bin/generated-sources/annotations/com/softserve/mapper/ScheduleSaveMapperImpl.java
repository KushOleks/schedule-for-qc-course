package com.softserve.mapper;

import com.softserve.dto.ScheduleSaveDTO;
import com.softserve.entity.Lesson;
import com.softserve.entity.Period;
import com.softserve.entity.Room;
import com.softserve.entity.Schedule;
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
public class ScheduleSaveMapperImpl implements ScheduleSaveMapper {

    @Override
    public ScheduleSaveDTO scheduleToScheduleSaveDTO(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        ScheduleSaveDTO scheduleSaveDTO = new ScheduleSaveDTO();

        scheduleSaveDTO.setRoomId( scheduleRoomId( schedule ) );
        scheduleSaveDTO.setPeriodId( schedulePeriodId( schedule ) );
        scheduleSaveDTO.setDayOfWeek( schedule.getDayOfWeek() );
        scheduleSaveDTO.setEvenOdd( schedule.getEvenOdd() );
        scheduleSaveDTO.setLessonId( scheduleLessonId( schedule ) );
        scheduleSaveDTO.setId( schedule.getId() );

        return scheduleSaveDTO;
    }

    @Override
    public Schedule scheduleSaveDTOToSchedule(ScheduleSaveDTO scheduleSaveDTO) {
        if ( scheduleSaveDTO == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setRoom( scheduleSaveDTOToRoom( scheduleSaveDTO ) );
        schedule.setPeriod( scheduleSaveDTOToPeriod( scheduleSaveDTO ) );
        schedule.setLesson( scheduleSaveDTOToLesson( scheduleSaveDTO ) );
        schedule.setDayOfWeek( scheduleSaveDTO.getDayOfWeek() );
        schedule.setEvenOdd( scheduleSaveDTO.getEvenOdd() );

        return schedule;
    }

    @Override
    public List<Schedule> scheduleSaveDTOsListToSchedulesList(List<ScheduleSaveDTO> scheduleSaveDTOs) {
        if ( scheduleSaveDTOs == null ) {
            return null;
        }

        List<Schedule> list = new ArrayList<Schedule>( scheduleSaveDTOs.size() );
        for ( ScheduleSaveDTO scheduleSaveDTO : scheduleSaveDTOs ) {
            list.add( scheduleSaveDTOToSchedule( scheduleSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<ScheduleSaveDTO> schedulesListToScheduleSaveDTOsList(List<Schedule> schedules) {
        if ( schedules == null ) {
            return null;
        }

        List<ScheduleSaveDTO> list = new ArrayList<ScheduleSaveDTO>( schedules.size() );
        for ( Schedule schedule : schedules ) {
            list.add( scheduleToScheduleSaveDTO( schedule ) );
        }

        return list;
    }

    private Long scheduleRoomId(Schedule schedule) {
        Room room = schedule.getRoom();
        if ( room == null ) {
            return null;
        }
        return room.getId();
    }

    private Long schedulePeriodId(Schedule schedule) {
        Period period = schedule.getPeriod();
        if ( period == null ) {
            return null;
        }
        return period.getId();
    }

    private Long scheduleLessonId(Schedule schedule) {
        Lesson lesson = schedule.getLesson();
        if ( lesson == null ) {
            return null;
        }
        return lesson.getId();
    }

    protected Room scheduleSaveDTOToRoom(ScheduleSaveDTO scheduleSaveDTO) {
        if ( scheduleSaveDTO == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( scheduleSaveDTO.getRoomId() );

        return room;
    }

    protected Period scheduleSaveDTOToPeriod(ScheduleSaveDTO scheduleSaveDTO) {
        if ( scheduleSaveDTO == null ) {
            return null;
        }

        Period period = new Period();

        period.setId( scheduleSaveDTO.getPeriodId() );

        return period;
    }

    protected Lesson scheduleSaveDTOToLesson(ScheduleSaveDTO scheduleSaveDTO) {
        if ( scheduleSaveDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( scheduleSaveDTO.getLessonId() );

        return lesson;
    }
}
