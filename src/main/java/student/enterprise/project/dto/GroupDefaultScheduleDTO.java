package student.enterprise.project.dto;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GroupDefaultScheduleDTO {
	private List<List<ChangeDTO>> days = new ArrayList<>();
	
	private Long VERSION_TIMESTAMP;
	
	public GroupDefaultScheduleDTO() {
		for(int i=0; i<6; i++) {
			List<ChangeDTO> lst = new ArrayList<>();
			for(int j=0; j<5; j++) {
				lst.add(new ChangeDTO());
			}
			days.add(lst);
		}
	}
	
	public void changeLesson(ChangeDTO lesson, DayOfWeek day, int lessonNumber) {
		if(lessonNumber==0) {
			return;
		}
		int dayNumber = day.getValue();
		days.get(dayNumber-1).set(lessonNumber-1, lesson);
		
	}
	
	
	
	public void printSchedule() {
		System.out.println("Timestamp: "+this.VERSION_TIMESTAMP);
		int dayN = 1;
		int lessonN = 1;
		for(List<ChangeDTO> day : days) {
			lessonN=1;
			System.out.println("Day: "+dayN);
			for(ChangeDTO lesson : day) {
				System.out.print(lessonN+".");
				if(lesson.getLessonId()==null) {
					System.out.println("No lesson");
				}else
				System.out.println(lesson);
				lessonN++;
			}
			dayN++;
		}
	}
	
}
