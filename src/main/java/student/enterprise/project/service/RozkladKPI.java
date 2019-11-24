package student.enterprise.project.service;

import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.dto.rozkladKPI.KpiTimetableDTO;
import student.enterprise.project.dto.rozkladKPI.ResponseKpiDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;

import java.util.List;

public interface RozkladKPI {

    KpiTimetableDTO getGroupTimetable(String groupName);

    KpiTimetableDTO getGroupTimetable(Long groupId);

    List<KpiTimetableDTO> getAllTimeTables();

}
