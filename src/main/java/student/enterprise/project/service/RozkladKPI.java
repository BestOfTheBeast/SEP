package student.enterprise.project.service;

import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;

import java.util.List;

public interface RozkladKPI {

    List<ChangeEntity> getLessons(String groupName);

    GroupEntity getDefaultGroup(String groupName);

}
