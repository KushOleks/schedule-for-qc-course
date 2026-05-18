package com.softserve.mapper;

import com.softserve.dto.PeriodDTO;
import com.softserve.dto.ScheduleWithoutSemesterDTO;
import com.softserve.entity.Period;
import com.softserve.entity.Schedule;
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
public class ScheduleWithoutSemesterMapperImpl implements ScheduleWithoutSemesterMapper {

    @Autowired
    private LessonInfoMapper lessonInfoMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public ScheduleWithoutSemesterDTO scheduleToScheduleWithoutSemesterDTO(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        ScheduleWithoutSemesterDTO scheduleWithoutSemesterDTO = new ScheduleWithoutSemesterDTO();

        scheduleWithoutSemesterDTO.setDayOfWeek( schedule.getDayOfWeek() );
        scheduleWithoutSemesterDTO.setEvenOdd( schedule.getEvenOdd() );
        scheduleWithoutSemesterDTO.setId( schedule.getId() );
        scheduleWithoutSemesterDTO.setLesson( lessonInfoMapper.lessonToLessonInfoDTO( schedule.getLesson() ) );
        scheduleWithoutSemesterDTO.setPeriod( periodToPeriodDTO( schedule.getPeriod() ) );
        scheduleWithoutSemesterDTO.setRoom( roomMapper.convertToDto( schedule.getRoom() ) );

        return scheduleWithoutSemesterDTO;
    }

    @Override
    public Schedule scheduleWithoutSemesterDTOToSchedule(ScheduleWithoutSemesterDTO scheduleWithoutSemesterDTO) {
        if ( scheduleWithoutSemesterDTO == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setDayOfWeek( scheduleWithoutSemesterDTO.getDayOfWeek() );
        schedule.setEvenOdd( scheduleWithoutSemesterDTO.getEvenOdd() );
        schedule.setId( scheduleWithoutSemesterDTO.getId() );
        schedule.setLesson( lessonInfoMapper.lessonInfoDTOToLesson( scheduleWithoutSemesterDTO.getLesson() ) );
        schedule.setPeriod( periodDTOToPeriod( scheduleWithoutSemesterDTO.getPeriod() ) );
        schedule.setRoom( roomMapper.convertToEntity( scheduleWithoutSemesterDTO.getRoom() ) );

        return schedule;
    }

    @Override
    public List<ScheduleWithoutSemesterDTO> scheduleToScheduleWithoutSemesterDTOs(List<Schedule> schedules) {
        if ( schedules == null ) {
            return null;
        }

        List<ScheduleWithoutSemesterDTO> list = new ArrayList<ScheduleWithoutSemesterDTO>( schedules.size() );
        for ( Schedule schedule : schedules ) {
            list.add( scheduleToScheduleWithoutSemesterDTO( schedule ) );
        }

        return list;
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
}
