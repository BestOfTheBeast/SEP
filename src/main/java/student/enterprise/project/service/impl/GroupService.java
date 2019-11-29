package student.enterprise.project.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.time.LocalDateTime;
import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;
import student.enterprise.project.service.ChangeService;

@Service
@RequiredArgsConstructor
public class GroupService {

  private ChangeService changeService;

  private final GroupRepository groupRepository;

  public List<ChangeDTO> getAllChanges(GroupEntity groupEntity) {
    if (Objects.isNull(groupEntity)) {
      return Lists.newArrayList();
    }
    Map<LocalDateTime, ChangeDTO> changeMap = Maps.newHashMap();
    putAllChangesRecursive(groupEntity, changeMap);
    return new ArrayList<>(changeMap.values());
  }

  private void putAllChangesRecursive(GroupEntity groupEntity, Map<LocalDateTime, ChangeDTO> changeMap) {
    if (Objects.isNull(groupEntity) || CollectionUtils.isEmpty(groupEntity.getChangeList())) {
      return;
    }
      groupEntity.getChangeList().parallelStream()
              .map(change -> changeService.toDto(change))
              .flatMap(Collection::stream)
              .forEach(change -> changeMap.put(change.getDateTime(), change));
    if (groupEntity.hasParent()) {
      putAllChangesRecursive(groupEntity.getParentGroup(), changeMap);
    }
  }

}
