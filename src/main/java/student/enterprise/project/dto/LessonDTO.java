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
    
    public LocalTime getStartTime() {
    	return this.timeStart;
    }
    public LocalTime getEndTime() {
    	return this.timeEnd;
    }
	public LocalTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}
	public LocalTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "LessonDTO [timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", number=" + number + "]";
	}
    

}
