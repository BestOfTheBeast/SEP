  
package student.enterprise.project.dto.rozkladKPI;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;


@Data
public class KpiTimetableDTO {

  @JsonProperty("group")
  private KpiGroupDTO group;

  //TODO replace this parameter by corresponding DTO
  @JsonProperty("weeks")
  //private JsonNode weeks;
  private KpiTwoWeekScheduleDTO weeks;
}