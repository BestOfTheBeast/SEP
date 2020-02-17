package student.enterprise.project.dto.rozkladKPI;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RozkladLessonDTO {

	
	@JsonProperty("lesson_id")
	private int id;
	
	
	@JsonProperty("lesson_full_name")
	private String name;
	
	@JsonProperty("lesson_number")
	private int number;
	
	@JsonProperty("lesson_type")
	private String type;
	
	@JsonProperty("time_start")
	private LocalTime timeStart;
	
	@JsonProperty("time_end")
	private LocalTime timeEnd;
	
	@JsonProperty("teachers")
	private List<RozkladTeacherDTO> teachers;
	
	@JsonProperty("rooms")
	private List<RozkladRoomDTO> rooms;

}
