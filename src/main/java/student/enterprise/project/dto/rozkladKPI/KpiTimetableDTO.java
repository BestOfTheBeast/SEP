
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
public class KpiTimetableDTO {

	@JsonProperty("group")
	private KpiGroupDTO group;

	@JsonProperty("weeks")
	private KpiTwoWeekScheduleDTO weeks;
}