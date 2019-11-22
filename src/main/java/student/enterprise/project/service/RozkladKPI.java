package student.enterprise.project.service;

import java.util.List;
import student.enterprise.project.dto.GroupDefaultSchedule;

public interface RozkladKPI {

    //List<LessonDTO> getLessons(String groupName);

	GroupDefaultSchedule getDefaultGroup(String groupName);

}
