  
package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.dto.enums.LecturerDegree;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeDTO {

    private Long id;

    
    private String name;
    
    private Long lessonId;
    
    private LessonDTO lessonDTO = new LessonDTO();

    private LecturerDTO lecturerDTO = new LecturerDTO();

    private RoomDTO roomDTO = new RoomDTO();
    
    private int dayNumber;
    
    private String dayName;
    
}