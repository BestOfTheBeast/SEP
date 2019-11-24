package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class GroupData {

  @JsonProperty("group")
  private RozkladKpiGroupDTO group;
  @JsonProperty("weeks")
  private JsonNode weeks;
}
