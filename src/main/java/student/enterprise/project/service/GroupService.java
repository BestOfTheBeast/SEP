package student.enterprise.project.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository groupRepository;

  public List<ChangeEntity> getAllChanges(GroupEntity groupEntity) {
    if (Objects.isNull(groupEntity)) {
      return Lists.newArrayList();
    }
    Map<LocalDateTime, ChangeEntity> changeMap = Maps.newHashMap();
    getAllChangesRecursive(groupEntity, changeMap);
    return new ArrayList<>(changeMap.values());
  }

  private void getAllChangesRecursive(GroupEntity groupEntity, Map<LocalDateTime, ChangeEntity> changeMap) {
    if (Objects.isNull(groupEntity) || CollectionUtils.isEmpty(groupEntity.getChangeList())) {
      return;
    }
    groupEntity.getChangeList().parallelStream()
        .forEach(change -> changeMap.put(change.getDateTime(), change));
    if (groupEntity.hasParent()) {
      getAllChangesRecursive(groupEntity.getParentGroup(), changeMap);
    }
  }

}
