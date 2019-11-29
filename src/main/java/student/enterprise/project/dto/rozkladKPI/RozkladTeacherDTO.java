package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RozkladTeacherDTO {

	
	@JsonProperty("teacher_id")
	private int id;
	
	@JsonProperty("teacher_name")
	private String teacherNameSurnameSecondname;

}
