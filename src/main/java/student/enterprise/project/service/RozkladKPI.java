package student.enterprise.project.service;

import student.enterprise.project.dto.rozkladKPI.KpiGroupDTO;
import student.enterprise.project.dto.rozkladKPI.KpiTimetableDTO;

import java.util.List;

public interface RozkladKPI {

    KpiTimetableDTO getGroupTimetable(String groupName);

    KpiTimetableDTO getGroupTimetable(Long groupId);

    List<KpiGroupDTO> getAllGroups();

}