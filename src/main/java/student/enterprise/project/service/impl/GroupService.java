package student.enterprise.project.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.GroupDtoConvertor;
import student.enterprise.project.converter.impl.GroupEntityConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;
import student.enterprise.project.service.CRUDService;

@Service
@RequiredArgsConstructor
public class GroupService implements CRUDService<GroupDTO>{

  private final ChangeService changeService;
  private final GroupEntityConverter groupEntityConverter;
  private final GroupDtoConvertor groupDtoConvertor;
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
    GroupEntity groupEntity = groupRepository.save(groupDtoConvertor.toEntity(groupDTO));
    return groupEntityConverter.toDto(groupEntity);
  }

  @Override
  public GroupDTO get(long id) {
    GroupEntity groupEntity = groupRepository.findById(id).orElseThrow(() -> new NullPointerException());
    return groupEntityConverter.toDto(groupEntity);
  }

  @Override
  public List<GroupDTO> getAll() {
    List<GroupEntity> groupEntity = groupRepository.findAll();
    return groupEntityConverter.toDto(groupEntity);
  }

  @Override
  public GroupDTO update(GroupDTO groupDTO) {
    GroupEntity groupEntity = groupRepository.getOne(groupDTO.getId());
    groupEntity.setCreated(groupEntity.getCreated());
    groupEntity.setParentGroup(groupEntity.getParentGroup());
    groupEntity.setUserRoleList(groupEntity.getUserRoleList());
    groupRepository.save(groupEntity);
    return groupEntityConverter.toDto(groupEntity);
  }

  @Override
  public void delete(long id) {
    if (!groupRepository.findById(id).isPresent()) {
      throw new NullPointerException();
    }
    groupRepository.deleteById(id);
  }
}
