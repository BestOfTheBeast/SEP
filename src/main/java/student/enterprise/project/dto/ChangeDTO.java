  
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
    
    
    
    public void setLessonStartTime(LocalTime time) {
    	this.lessonDTO.setTimeStart(time);
    }
    
    
    public void setLessonEndTime(LocalTime time) {
    	this.lessonDTO.setTimeEnd(time);
    }
    
    
    public void setLessonNumber(int number) {
    	this.lessonDTO.setNumber(number);
    }
    
    
    public void setRoomId(Long id) {
    	this.roomDTO.setId(id);
    }
    
    
    public void setRoom(String room) {
    	this.roomDTO.setRoom(room);
    }
    
    
    public void setBuilding(int building) {
    	this.roomDTO.setBuilding(building);
    }
   
    
    public void setLecturerId(Long id) {
    	this.lecturerDTO.setId(id);
    }
    
    
    public void setLecturerName(String name) {
    	this.lecturerDTO.setName(name);
    }
    
    
    public void setLecturerSurname(String surname) {
    	this.lecturerDTO.setSurname(surname);
    }
    
    
    public void setLecturerSecondName(String secondName) {
    	this.lecturerDTO.setSecondName(secondName);
    }
    
    
    public void setLecturerDegree(String degree) {
    	this.lecturerDTO.setDegree(degree);
    }
    
   
  
    
}