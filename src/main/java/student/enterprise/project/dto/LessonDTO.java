package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {

	private LocalTime timeStart;
    
    private LocalTime timeEnd;

    private Integer number;
    
    
    

}
