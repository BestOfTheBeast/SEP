package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseKpiDTO {

    private Integer timeStamp;
    private JsonNode meta;
    private JsonNode debugInfo;
    private String message;
    private Integer statusCode;
    @JsonProperty("data")
    private KpiTimetableDTO data;

}
