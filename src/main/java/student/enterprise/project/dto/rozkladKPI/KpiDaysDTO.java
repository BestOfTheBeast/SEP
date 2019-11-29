package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KpiDaysDTO {

	@JsonProperty("1")
	private KpiDayDTO firstDay;
	
	@JsonProperty("2")
	private KpiDayDTO secondDay;
	
	@JsonProperty("3")
	private KpiDayDTO thirdDay;
	
	@JsonProperty("4")
	private KpiDayDTO fourthDay;
	
	@JsonProperty("5")
	private KpiDayDTO fifthDay;
	
	@JsonProperty("6")
	private KpiDayDTO sixthDay;
	
}