package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KpiWeekDTO {
	
	@JsonProperty("week_number")
	private int weekNumber;
	
	@JsonProperty("days")
	private KpiDaysDTO days;
	
}
