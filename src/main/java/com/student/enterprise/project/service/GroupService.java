package com.student.enterprise.project.service;

import com.google.common.collect.Lists;
import com.student.enterprise.project.entity.ChangeEntity;
import com.student.enterprise.project.entity.GroupEntity;
import com.student.enterprise.project.repository.GroupRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository groupRepository;

  public List<ChangeEntity> getAllChanges(GroupEntity groupEntity) {
    if (Objects.isNull(groupEntity)) {
      return Lists.newArrayList();
    }
    //TODO recursive solution with Map<LocalDateTime, ChangeEntity>
  }

}
