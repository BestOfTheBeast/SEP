package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
public class KpiDayDTO {

	@JsonProperty("day_name")
	private String name;
	
	@JsonProperty("day_number")
	private int number;
	
	@JsonProperty("lessons")
	private List<RozkladLessonDTO> lessons;
	
}
