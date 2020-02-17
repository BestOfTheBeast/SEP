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
public class KpiWeekDTO {
	

	@JsonProperty("week_number")
	private int weekNumber;

	@JsonProperty("days")
	private KpiDaysDTO days;

}
