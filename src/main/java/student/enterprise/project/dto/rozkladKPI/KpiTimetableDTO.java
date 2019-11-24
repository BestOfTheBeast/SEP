package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class KpiTimetableDTO {

  @JsonProperty("group")
  private KpiGroupDTO group;

  //TODO replace this parameter by corresponding DTO
  @JsonProperty("weeks")
  private JsonNode weeks;
}
