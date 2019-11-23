package student.enterprise.project.service;

import java.util.List;
import student.enterprise.project.dto.GroupDefaultScheduleDTO;

public interface RozkladKPI {

    //List<LessonDTO> getLessons(String groupName);

	GroupDefaultScheduleDTO getDefaultGroup(String groupName);

}
