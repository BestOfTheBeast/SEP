package student.enterprise.project.service;

import student.enterprise.project.entity.ChangeEntity;

import java.util.List;

public interface RozkladKPI {

    List<ChangeEntity> getSchedule(String groupName);

}
