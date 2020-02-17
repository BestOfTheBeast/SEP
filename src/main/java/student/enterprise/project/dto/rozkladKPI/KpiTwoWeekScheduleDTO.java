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
public class KpiTwoWeekScheduleDTO {

	
	@JsonProperty("1")
	private KpiWeekDTO firstWeek;
	
	@JsonProperty("2")
	private KpiWeekDTO secondWeek;
	
}
