package student.enterprise.project.dto.rozkladKPI;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class KpiGroupResponse {
	private Integer timeStamp;
	private JsonNode meta;
	private JsonNode debugInfo;
	private String message;
	private Integer statusCode;
	private List<KpiGroupDTO> data;

}
