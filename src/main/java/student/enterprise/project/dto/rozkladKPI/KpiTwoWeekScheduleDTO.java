package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KpiTwoWeekScheduleDTO {

	
	@JsonProperty("1")
	private KpiWeekDTO firstWeek;
	
	@JsonProperty("2")
	private KpiWeekDTO secondWeek;
	
}
