package student.enterprise.project.dto.rozkladKPI;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KpiDayDTO {

	@JsonProperty("day_name")
	private String name;

	@JsonProperty("day_number")
	private int number;

	@JsonProperty("lessons")
	private List<RozkladLessonDTO> lessons;

}
