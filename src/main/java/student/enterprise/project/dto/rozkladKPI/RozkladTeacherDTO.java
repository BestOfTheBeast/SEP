package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RozkladTeacherDTO {

	
	@JsonProperty("teacher_id")
	private int id;
	
	@JsonProperty("teacher_name")
	private String teacherNameSurnameSecondname;

}
