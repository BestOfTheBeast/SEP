package student.enterprise.project.converter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.dto.rozkladKPI.KpiDayDTO;
import student.enterprise.project.dto.rozkladKPI.KpiDaysDTO;
import student.enterprise.project.dto.rozkladKPI.KpiGroupDTO;
import student.enterprise.project.dto.rozkladKPI.KpiTimetableDTO;
import student.enterprise.project.dto.rozkladKPI.KpiTwoWeekScheduleDTO;
import student.enterprise.project.dto.rozkladKPI.KpiWeekDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladLessonDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladRoomDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladTeacherDTO;
import student.enterprise.project.entity.rozkladKPI.KpiDayEntity;
import student.enterprise.project.entity.rozkladKPI.KpiGroupEntity;
import student.enterprise.project.entity.rozkladKPI.KpiTimetableEntity;
import student.enterprise.project.entity.rozkladKPI.KpiTwoWeekScheduleEntity;
import student.enterprise.project.entity.rozkladKPI.KpiWeekEntity;
import student.enterprise.project.entity.rozkladKPI.RozkladLessonEntity;

public class KpiTimetableEntityConverter extends AbstractEntityConverter<KpiTimetableEntity, KpiTimetableDTO> {

	public KpiTimetableEntityConverter(Class<KpiTimetableDTO> dtoClass, ModelMapper mapper) {
		super(dtoClass, mapper);

	}

	public KpiTimetableDTO toDTO(KpiTimetableEntity entity) {
		KpiTimetableDTO res = new KpiTimetableDTO();

		// parse group dto from group entity
		KpiGroupEntity groupEntity = entity.getGroup();
		KpiGroupDTO groupDTO = new KpiGroupDTO(groupEntity.getId(), groupEntity.getGroup_full_name(),
				groupEntity.getGroup_prefix(), groupEntity.getGroup_okr(), groupEntity.getGroup_type(),
				groupEntity.getGroup_url());

		// set group dto to result
		res.setGroup(groupDTO);

		// parse two week schedule dto from two week schedule entity
		KpiTwoWeekScheduleEntity timeEntity = entity.getWeeks();
		KpiTwoWeekScheduleDTO timeDTO = new KpiTwoWeekScheduleDTO();

		// parse week1 dto from week1 entity
		KpiWeekDTO week1DTO = new KpiWeekDTO();
		KpiWeekEntity week1Entity = timeEntity.getFirst_week();

		KpiWeekDTO week2DTO = new KpiWeekDTO();
		KpiWeekEntity week2Entity = timeEntity.getSecond_week();
		week2DTO.setWeekNumber(week2Entity.getWeekNumber());

		List<KpiWeekEntity> weekEntities = Arrays.asList(new KpiWeekEntity[] { week1Entity, week2Entity });
		List<KpiWeekDTO> weekDTOs = Arrays.asList(new KpiWeekDTO[] { week1DTO, week2DTO });

		for (int k = 0; k < weekEntities.size(); k++) {
			// parse days dto from week1 entity
			KpiWeekEntity weekEntity = weekEntities.get(0);
			weekDTOs.get(k).setWeekNumber(week1Entity.getWeekNumber());
			KpiDaysDTO daysDTO = new KpiDaysDTO();
			KpiDayEntity day1 = weekEntity.getDay1();
			KpiDayEntity day2 = weekEntity.getDay2();
			KpiDayEntity day3 = weekEntity.getDay3();
			KpiDayEntity day4 = weekEntity.getDay4();
			KpiDayEntity day5 = weekEntity.getDay5();
			KpiDayEntity day6 = weekEntity.getDay6();

			KpiDayDTO day1dto = new KpiDayDTO();
			KpiDayDTO day2dto = new KpiDayDTO();
			KpiDayDTO day3dto = new KpiDayDTO();
			KpiDayDTO day4dto = new KpiDayDTO();
			KpiDayDTO day5dto = new KpiDayDTO();
			KpiDayDTO day6dto = new KpiDayDTO();

			List<KpiDayEntity> dayEntities = Arrays.asList(new KpiDayEntity[] { day1, day2, day3, day4, day5, day6 });
			List<KpiDayDTO> dayDTOs = Arrays
					.asList(new KpiDayDTO[] { day1dto, day2dto, day3dto, day4dto, day5dto, day6dto });

			// parse every day dto from corresponding day entity
			for (int i = 0; i < dayEntities.size(); i++) {
				KpiDayDTO dayDTO = dayDTOs.get(i);
				KpiDayEntity dayEntity = dayEntities.get(i);

				dayDTO.setName(dayEntity.getName());
				dayDTO.setNumber(dayEntity.getNumber());

				List<RozkladLessonEntity> lessonEntities = dayEntity.getLessons();
				List<RozkladLessonDTO> lessonDTOs = new ArrayList<>(lessonEntities.size());

				// parse lessons
				for (int j = 0; j < lessonEntities.size(); j++) {
					RozkladLessonDTO lessonDTO = new RozkladLessonDTO();
					RozkladLessonEntity lessonEntity = lessonEntities.get(j);

					lessonDTO.setId(lessonEntity.getId());
					lessonDTO.setName(lessonEntity.getName());
					lessonDTO.setNumber(lessonEntity.getNumber());
					lessonDTO.setType(lessonEntity.getType());
					lessonDTO.setTimeStart(lessonEntity.getTimeStart());
					lessonDTO.setTimeEnd(lessonEntity.getTimeEnd());
					lessonDTO.setTeacher(new RozkladTeacherDTO(lessonEntity.getTeacher().getId(),
							lessonEntity.getTeacher().getTeacherNameSurnameSecondname()));
					lessonDTO.setRoom(
							new RozkladRoomDTO(lessonEntity.getRoom().getId(), lessonEntity.getRoom().getName()));
					lessonDTOs.set(j, lessonDTO);

				}
				dayDTO.setLessons(lessonDTOs);
				dayDTOs.set(i, dayDTO);
			}

			daysDTO.setFirstDay(dayDTOs.get(0));
			daysDTO.setSecondDay(dayDTOs.get(1));
			daysDTO.setThirdDay(dayDTOs.get(2));
			daysDTO.setFourthDay(dayDTOs.get(3));
			daysDTO.setFifthDay(dayDTOs.get(4));
			daysDTO.setSixthDay(dayDTOs.get(5));

			if (k == 0) {
				weekDTOs.get(k).setDays(daysDTO);
				timeDTO.setFirstWeek(weekDTOs.get(k));
			} else {
				weekDTOs.get(k).setDays(daysDTO);
				timeDTO.setSecondWeek(weekDTOs.get(k));
			}

		}

		res.setWeeks(timeDTO);

		return res;
	}

}
