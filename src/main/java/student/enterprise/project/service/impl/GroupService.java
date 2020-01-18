package student.enterprise.project.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;
import student.enterprise.project.service.CRUDService;

@RequiredArgsConstructor
public class GroupService implements CRUDService<GroupDTO>{

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
//    if (Objects.isNull(groupEntity) || CollectionUtils.isEmpty(groupEntity.getChangeList())) {
//      return;
//    }
//      groupEntity.getChangeList().parallelStream()
//              .map(change -> changeService.toDto(change))
//              .flatMap(Collection::stream)
//              .forEach(change -> changeMap.put(change.getDateTime(), change));
//    if (groupEntity.hasParent()) {
//      putAllChangesRecursive(groupEntity.getParentGroup(), changeMap);
//    }
  }

  @Override
  public GroupDTO create(GroupDTO groupDTO) {
    //TODO implement service method
    return null;
  }

  @Override
  public GroupDTO get(long id) {
    //TODO implement service method
    return null;
  }

  @Override
  public List<GroupDTO> getAll() {
    //TODO implement service method
    return null;
  }

  @Override
  public GroupDTO update(GroupDTO groupDTO) {
    //TODO implement service method
    return null;
  }

  @Override
  public void delete(long id) {
    //TODO implement service method
  }
}
