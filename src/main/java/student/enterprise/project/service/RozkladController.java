package student.enterprise.project.service;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.dto.GroupDefaultSchedule;

public class RozkladController implements RozkladKPI{

	@Override
	public GroupDefaultSchedule getDefaultGroup(String groupName) {
		GroupDefaultSchedule schedule = new GroupDefaultSchedule();
		
		HttpRequestSender r = HttpRequestSender.get();
		JSONObject o = r.sendGet("http://api.rozklad.org.ua/v2/groups/"+groupName+"/timetable");
		String timestamp = o.get("timeStamp").toString();
		schedule.setTimestamp(Long.parseLong(timestamp));
		String data = o.get("data").toString();
		
		JSONParser parser = new JSONParser();
		JSONObject dataJSON = new JSONObject();
		try {
		dataJSON = (JSONObject) parser.parse(data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String weeks = dataJSON.get("weeks").toString();
		
		parser = new JSONParser();
		
		//get JSONobject of all weeks
		JSONObject weeksJSON = new JSONObject();
		try {
			weeksJSON = (JSONObject) parser.parse(weeks);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		//loop through all weeks
		for(Object week : weeksJSON.keySet()) {
			String weekKey = (String)week;
			parser = new JSONParser();
			
			//get JSON object of single week
			JSONObject weekJSON = new JSONObject();
			try {
				weekJSON = (JSONObject) parser.parse(weeksJSON.get(weekKey).toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//get JSON object of days in week
			JSONObject daysJSON = new JSONObject();
			try {
				daysJSON = (JSONObject) parser.parse(weekJSON.get("days").toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//loop through all days in week
			for(Object day : daysJSON.keySet()) {
				String dayName = "";
				int lessonNumber = 0;
				Long dayNumber = 0L;
				JSONObject dayJSON = new JSONObject();
				try {
					dayJSON = (JSONObject) parser.parse(daysJSON.get((String)day).toString());
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				dayName = (String)dayJSON.get("day_name");
				dayNumber = (Long)dayJSON.get("day_number");
				
				JSONArray lessonsJSON = new JSONArray();
				try {
					lessonsJSON = (JSONArray) parser.parse(dayJSON.get("lessons").toString());
				}catch(Exception e) {
					e.printStackTrace();
				}
				for(Object lesson : lessonsJSON) {
					ChangeDTO dayDTO = new ChangeDTO();
					dayDTO.setDayName(dayName);
					dayDTO.setDayNumber(dayNumber);
					String lessonStr = lesson.toString();
					JSONObject lessonJSON = new JSONObject();
					try {
						lessonJSON = (JSONObject) parser.parse(lessonStr);
					}catch(Exception e) {
						e.printStackTrace();
					}
					String lessonName = (String)lessonJSON.get("lesson_full_name");
					dayDTO.setLessonName(lessonName);
					String timeStartStr = (String)lessonJSON.get("time_start");
					LocalTime timeStart = LocalTime.parse(timeStartStr);
					dayDTO.setLessonStartTime(timeStart);
					String timeEndStr = (String)lessonJSON.get("time_end");
					LocalTime timeEnd = LocalTime.parse(timeEndStr);
					dayDTO.setLessonEndTime(timeEnd);
					lessonNumber = Integer.parseInt((String)lessonJSON.get("lesson_number"));
					dayDTO.setLessonNumber(lessonNumber);
					Long lessonId = Long.parseLong((String)lessonJSON.get("lesson_id"));
					dayDTO.setLessonId(lessonId);
					
					JSONArray roomsJSON = new JSONArray();
					try {
						roomsJSON = (JSONArray) parser.parse(lessonJSON.get("rooms").toString());
					}catch(Exception e) {
						e.printStackTrace();
					}
					String roomNumberStr = "";
					int buildingNumber = 0; 
					try {
					JSONObject roomJSON = (JSONObject)roomsJSON.get(0);
					String roomIdStr = (String)roomJSON.get("room_id");
					Long roomId = Long.parseLong(roomIdStr);
					dayDTO.setRoomId(roomId);
					String roomCode = (String)roomJSON.get("room_name");
					roomNumberStr = roomCode.split("-")[0];
					String buildingNumberStr = roomCode.split("-")[1];
					buildingNumber = Integer.parseInt(buildingNumberStr);
					}catch(IndexOutOfBoundsException e) {
						
					}
					dayDTO.setRoom(roomNumberStr);
					dayDTO.setBuilding(buildingNumber);
					JSONArray lectorsJSON = new JSONArray();
					try {
						lectorsJSON = (JSONArray) parser.parse(lessonJSON.get("teachers").toString());
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					try {
					JSONObject lectorJSON = (JSONObject)lectorsJSON.get(0);
					
					String lecturerIdStr = (String)lectorJSON.get("teacher_id");
					Long lecturerId = Long.parseLong(lecturerIdStr);
					String lectorFullName = (String)lectorJSON.get("teacher_full_name");
					String lectorDegreeStr = lectorFullName.split(" ")[0];
					String lectorName = lectorFullName.split(" ")[1];
					String lectorSurname = lectorFullName.split(" ")[2];
					String lectorSecondName = lectorFullName.split(" ")[3];
					
					dayDTO.setLecturerDegree(lectorDegreeStr);
					dayDTO.setLecturerId(lecturerId);
					dayDTO.setLecturerName(lectorName);
					dayDTO.setLecturerSurname(lectorSurname);
					dayDTO.setLecturerSecondName(lectorSecondName);
					}catch(IndexOutOfBoundsException e) {
						dayDTO.setLecturerId(0L);
					}
					schedule.changeLesson(dayDTO, dayConverter(dayName), lessonNumber);
				}
			
			
			}
		}
		
		return schedule;
		
	}
	
	private DayOfWeek dayConverter(String dayUkrName) {
		switch(dayUkrName) {
		case "Понеділок":
			return DayOfWeek.MONDAY;
		case "Вівторок":
			return DayOfWeek.TUESDAY;
		case "Середа":
			return DayOfWeek.WEDNESDAY;
		case "Четвер":
			return DayOfWeek.THURSDAY;
		case "П’ятниця":
			return DayOfWeek.FRIDAY;
		case "Субота":
			return DayOfWeek.SATURDAY;
		default:
			return null;
		}
	}

}
