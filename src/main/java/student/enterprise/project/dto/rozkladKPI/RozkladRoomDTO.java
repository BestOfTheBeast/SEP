package student.enterprise.project.dto.rozkladKPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RozkladRoomDTO {

	@JsonProperty("room_id")
	private int id;
	
	@JsonProperty("room_name")
	private String name;

}
