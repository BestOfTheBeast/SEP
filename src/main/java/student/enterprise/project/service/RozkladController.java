package student.enterprise.project.service;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.dto.GroupDefaultScheduleDTO;
import student.enterprise.project.dto.LecturerDTO;
import student.enterprise.project.dto.LessonDTO;
import student.enterprise.project.dto.RoomDTO;



public class RozkladController implements RozkladKPI{

	
	private HttpRequestSender r;
	
	private static RozkladController controller;
	
	private RozkladController() {
		this.r = HttpRequestSender.get();
	}
	
	public static RozkladController get() {
		if(controller == null) {
			controller = new RozkladController();
		}
		return controller;
	}
	
	@Override
	public GroupDefaultScheduleDTO getDefaultGroup(String groupName) {
		GroupDefaultScheduleDTO schedule = new GroupDefaultScheduleDTO();
		JSONObject o = r.sendGet("http://api.rozklad.org.ua/v2/groups/"+groupName+"/timetable");
		String timestamp = o.get("timeStamp").toString();
		schedule.setVERSION_TIMESTAMP(Long.parseLong(timestamp));
		JSONObject dataJSON = (JSONObject)o.get("data");
		//get JSONobject of all weeks
		JSONObject weeksJSON = (JSONObject)dataJSON.get("weeks");
		//loop through all weeks
		for(Object week : weeksJSON.keySet()) {
			String weekKey = (String)week;
			//get JSON object of single week
			JSONObject weekJSON = (JSONObject)weeksJSON.get(weekKey);
			//get JSON object of days in week
			JSONObject daysJSON = (JSONObject)weekJSON.get("days");
			//loop through all days in week
			for(Object day : daysJSON.keySet()) {
				String dayName = "";
				int lessonNumber = 0;
				int dayNumber = 0;
				//create JSON day object
				JSONObject dayJSON = (JSONObject)daysJSON.get((String)day);
				dayName = (String)dayJSON.get("day_name");
				dayNumber = (Integer)dayJSON.get("day_number");
				//create json array of lessons
				JSONArray lessonsJSON = (JSONArray)dayJSON.get("lessons");
				//loop through all lessons
				for(Object lesson : lessonsJSON) {
					//create new change dto for new lesson and fill it with parameters
					ChangeDTO dayDTO = new ChangeDTO();
					LessonDTO lessonDTO = new LessonDTO();
					RoomDTO roomDTO = new RoomDTO();
					LecturerDTO lecturerDTO = new LecturerDTO();
					dayDTO.setDayName(dayName);
					dayDTO.setDayNumber(dayNumber);
					String lessonStr = lesson.toString();
					JSONObject lessonJSON = new JSONObject(lessonStr);
					String lessonName = (String)lessonJSON.get("lesson_full_name");
					dayDTO.setName(lessonName);
					String timeStartStr = (String)lessonJSON.get("time_start");
					LocalTime timeStart = LocalTime.parse(timeStartStr);
					lessonDTO.setTimeStart(timeStart);
					String timeEndStr = (String)lessonJSON.get("time_end");
					LocalTime timeEnd = LocalTime.parse(timeEndStr);
					lessonDTO.setTimeEnd(timeEnd);
					lessonNumber = Integer.parseInt((String)lessonJSON.get("lesson_number"));
					lessonDTO.setNumber(lessonNumber);
					Long lessonId = Long.parseLong((String)lessonJSON.get("lesson_id"));
					dayDTO.setLessonId(lessonId);
					dayDTO.setLessonDTO(lessonDTO);
					JSONArray roomsJSON = (JSONArray)lessonJSON.get("rooms");
					String roomNumberStr = "";
					int buildingNumber = 0; 
					try {
					JSONObject roomJSON = (JSONObject)roomsJSON.get(0);
					String roomIdStr = (String)roomJSON.get("room_id");
					Long roomId = Long.parseLong(roomIdStr);
					roomDTO.setId(roomId);
					String roomCode = (String)roomJSON.get("room_name");
					roomNumberStr = roomCode.split("-")[0];
					String buildingNumberStr = roomCode.split("-")[1];
					buildingNumber = Integer.parseInt(buildingNumberStr);
					}catch(JSONException e) {
						
					}
					roomDTO.setRoom(roomNumberStr);
					roomDTO.setBuilding(buildingNumber);
					dayDTO.setRoomDTO(roomDTO);
					JSONArray lectorsJSON = (JSONArray)lessonJSON.get("teachers");
					try {
					JSONObject lectorJSON = (JSONObject)lectorsJSON.get(0);
					String lecturerIdStr = (String)lectorJSON.get("teacher_id");
					Long lecturerId = Long.parseLong(lecturerIdStr);
					String lectorFullName = (String)lectorJSON.get("teacher_full_name");
					String lectorDegreeStr = lectorFullName.split(" ")[0];
					String lectorName = lectorFullName.split(" ")[1];
					String lectorSurname = lectorFullName.split(" ")[2];
					String lectorSecondName = lectorFullName.split(" ")[3];
					lecturerDTO.setDegree(lectorDegreeStr);
					lecturerDTO.setId(lecturerId);
					lecturerDTO.setName(lectorName);
					lecturerDTO.setSurname(lectorSurname);
					lecturerDTO.setSecondName(lectorSecondName);
					}catch(JSONException e) {
						lecturerDTO.setId(0L);
					}
					dayDTO.setLecturerDTO(lecturerDTO);
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
