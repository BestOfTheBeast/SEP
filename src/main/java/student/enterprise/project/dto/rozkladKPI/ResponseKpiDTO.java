package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseKpiDTO {

    private Integer timeStamp;
    private JSONObject meta;
    private JSONObject debugInfo;
    private String message;
    private Integer statusCode;
    private JsonNode data;

}
