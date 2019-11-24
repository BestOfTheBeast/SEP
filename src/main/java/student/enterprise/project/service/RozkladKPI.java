package student.enterprise.project.service;

import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;

import java.util.List;

public interface RozkladKPI {

    GroupDTO getDefaultGroup(String groupName);

}
