package student.enterprise.project.converter.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import student.enterprise.project.converter.AbstractDtoConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.enums.LecturerDegree;
import student.enterprise.project.dto.rozkladKPI.KpiDayDTO;
import student.enterprise.project.dto.rozkladKPI.KpiDaysDTO;
import student.enterprise.project.dto.rozkladKPI.KpiTwoWeekScheduleDTO;
import student.enterprise.project.dto.rozkladKPI.KpiWeekDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladLessonDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladRoomDTO;
import student.enterprise.project.dto.rozkladKPI.RozkladTeacherDTO;
import student.enterprise.project.entity.LecturerEntity;
import student.enterprise.project.entity.LessonEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.RoomEntity;
import student.enterprise.project.entity.SubjectEntity;


@Converter
public class TimetableDtoConverter extends AbstractDtoConverter<RepeatableChangeEntity[], KpiTwoWeekScheduleDTO> {

	LocalDate firstSemesterStart = LocalDate.of(2020, 9, 1);
	LocalDate firstSemesterEnd = LocalDate.of(2020, 12, 31);
	LocalDate secondSemesterStart = LocalDate.of(2020, 1, 1);
	LocalDate secondSemesterEnd = LocalDate.of(2020, 6, 30);

	
	List<RepeatableChangeEntity> lessons = new ArrayList<>();
	
	
	public TimetableDtoConverter(ModelMapper mapper) {
		super(RepeatableChangeEntity[].class, mapper);
	}
	
	

	public RepeatableChangeEntity[] toEntity(KpiTwoWeekScheduleDTO dto) {
		// setup a list of weeks in the timetable
		List<KpiWeekDTO> weeks = Arrays.asList(dto.getFirstWeek(), dto.getSecondWeek());
		// run through both weeks
		for (KpiWeekDTO week : weeks) {
			// used to convert week and day info to 16-bit binary number
			int weekNumber = week.getWeekNumber();
			// get daysDTO of first week
			KpiDaysDTO weekDays1 = week.getDays();
			// setup a list of days in every week
			List<KpiDayDTO> days = Arrays.asList(
					weekDays1.getFirstDay(), weekDays1.getSecondDay(), weekDays1.getThirdDay(),
					weekDays1.getFourthDay(), weekDays1.getFifthDay(), weekDays1.getSixthDay());
			// run through every day
			for (KpiDayDTO day : days) {
				// used to convert week and day info to 16-bit binary number
				int dayNumber = day.getNumber();
				int lessonBit = ((weekNumber-1)*7)+dayNumber;
				
				// get list of lessons in the day
				List<RozkladLessonDTO> lessons = day.getLessons();
				// run through every lesson in day
				for (RozkladLessonDTO lesson : lessons) {
					//binary representation of lesson repeat pattern, last 2 bits must be 0's 
					long lessonRepeat = 0000_0000_0000_0000;
					//setting 1 to position of current day
					String lsnRptStr = longToStr(lessonRepeat);
					char[] lsnRptStrChrArr = lsnRptStr.toCharArray();
					lsnRptStrChrArr[15-(lessonBit-1)] = '1';
					lsnRptStr = String.valueOf(lsnRptStrChrArr);
					lessonRepeat = strToLong(lsnRptStr);
					Short lsnRptShrt = toDecimal(lessonRepeat);
					RozkladTeacherDTO teacher = null;
					RozkladRoomDTO room = null;
					if(lesson.getTeachers().size()!=0) {
						teacher = lesson.getTeachers().get(0);
						room = lesson.getRooms().get(0);
					}
					LecturerDegree degree = null;
					String name = "";
					String surname = "";
					String secondName = "";
					if(teacher!=null) {
						if (teacher.getTeacherNameSurnameSecondname().split(" ").length == 4) {
							String degreeString = teacher.getTeacherNameSurnameSecondname().split(" ")[0];
							degree = parseDegree(degreeString);
							surname = teacher.getTeacherNameSurnameSecondname().split(" ")[1];
							name = teacher.getTeacherNameSurnameSecondname().split(" ")[2];
							secondName = teacher.getTeacherNameSurnameSecondname().split(" ")[3];
						} else if (teacher.getTeacherNameSurnameSecondname().split(" ").length == 3) {
							degree = LecturerDegree.EMPTY;
							surname = teacher.getTeacherNameSurnameSecondname().split(" ")[0];
							name = teacher.getTeacherNameSurnameSecondname().split(" ")[1];
							secondName = teacher.getTeacherNameSurnameSecondname().split(" ")[2];
						} else if (teacher.getTeacherNameSurnameSecondname().split(" ").length == 5) {
							degree = LecturerDegree.ELDER_TEACHER;
							surname = teacher.getTeacherNameSurnameSecondname().split(" ")[2];
							name = teacher.getTeacherNameSurnameSecondname().split(" ")[3];
							secondName = teacher.getTeacherNameSurnameSecondname().split(" ")[4];
						}
						
					}
					
					
					LocalDate start = null;
					LocalDate end = null;
					if(isBetween(LocalDate.now(), firstSemesterStart, firstSemesterEnd)) {
						start = firstSemesterStart;
						end = firstSemesterEnd;
					}else {
						start = secondSemesterStart;
						end = secondSemesterEnd;
					}
					
				
					
					
					//building the final entity
					RepeatableChangeEntity entity = 
					RepeatableChangeEntity.builder()
							.lecturerEntity(teacher!=null?(
									LecturerEntity
									.builder()
									.degree(degree)
									.name(name)
									.surname(surname)
									.secondName(secondName)
									.build()):null)
							.lessonEntity(
									LessonEntity
									.builder()
									.time(lesson.getTimeStart())
									.number(lesson.getNumber())
									.build())
							.subjectEntity(
									SubjectEntity
									.builder()
									.name(lesson.getName())
									.build())
							.roomEntity(room!=null?(
									RoomEntity
									.builder()
									.name(room.getName())
									.build()):null)
							.twoWeekFlag(lsnRptShrt)
							.startDate(start)
							.endDate(end)
							.build();
					
					
					
					//check if lesson already exists
					RepeatableChangeEntity entRes = listContains(entity);
					if(entRes!=null) {
						this.lessons.remove(entRes);
						entity.setTwoWeekFlag(concatFlags(entRes.getTwoWeekFlag(), entity.getTwoWeekFlag()));
						this.lessons.add(entity);
					}else {
						this.lessons.add(entity);
					}
					
				}
			}
		}

		
		return this.lessons.toArray(new RepeatableChangeEntity[0]);
		
		
	}

	private Short toDecimal(long binary) {
		Short result = 0;
		String binaryStr = longToStr(binary);
		int strlen = binaryStr.length();
		int power = strlen-1;
		for (int i = 0; i < strlen; i++) {
			result = (short) ((int) result + (binaryStr.charAt(i) == '1' ? Math.pow(2, power) : 0));
			power--;
		}
		return result;
	}
	
	
	private long toBinary(Short decimal) {
		long result = 0;
		for (int i = 15; i > -1; i--) {
			if (decimal - Math.pow(2, i) >= 0) {
				result += Math.pow(10, i);
				decimal = (short) ((int) (decimal) - Math.pow(2, i));
			}
		}
		return result;
	}

	private LecturerDegree parseDegree(String degreeString) {
		List<String> allowedDegrees = Arrays
				.asList("професор", "доцент", "асистент", "викладач");
		if (!allowedDegrees.contains(degreeString))
			return LecturerDegree.EMPTY;
		switch (degreeString) {
		case "доцент":
			return LecturerDegree.DOCENT;
		case "професор":
			return LecturerDegree.PROFESSOR;
		case "асистент":
			return LecturerDegree.ASSISTANT;
		default:
			return LecturerDegree.TEACHER;
		}
	}
	
	private long strToLong(String number) {
		long result = 000000000000000;
		int strlen = number.length();
		int index=strlen-1;
		for(int i=0; i<strlen; i++) {
			if(number.charAt(i)=='1') {
				result+=Math.pow(10, index);
			}
			index--;
		}
		return result;
	}
	
	private String longToStr(long number) {
		number=number+(long)Math.pow(10, 16);
		String numStr = Long.toString(number);
		numStr = numStr.substring(1);
		
		return numStr;
	}
	
	private boolean isBetween(LocalDate date, LocalDate start, LocalDate end) {
		return date.isAfter(start)&&date.isBefore(end);
	}
	
	private RepeatableChangeEntity listContains(RepeatableChangeEntity entity) {
		Long l1 = 0L;
		if(entity.getRoomEntity()!=null) {
			l1 = entity.getRoomEntity().getId();
		}
		for(RepeatableChangeEntity e : this.lessons) {
			
			Long l2 = 0L;
			if(e.getRoomEntity()!=null) {
				l2 = e.getRoomEntity().getId();
			}
			if((Long.compare(l1, l2)==0)&&(e.getSubjectEntity().getName().equals(entity.getSubjectEntity().getName()))) {
				return e;
			}else {
			}
		}
		return null;
	}
	
	
	private Short concatFlags(Short flag1, Short flag2) {
		String str1 = longToStr(toBinary(flag1));
		String str2 = longToStr(toBinary(flag2));
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i]=='1') {
				arr2[i]='1';
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            stringBuilder.append(arr2[i]);
        }
		String resStr = stringBuilder.toString();
		long resLong = strToLong(resStr);
		Short result = toDecimal(resLong);
		
		return result;
		
	}
	
}
