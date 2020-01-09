package student.enterprise.project.service.impl;

import com.google.common.collect.Maps;
import java.time.LocalDateTime;
import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import student.enterprise.project.converter.impl.ChangeConverter;
import student.enterprise.project.converter.impl.GroupConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.repository.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final ChangeConverter changeConverter;
  private final GroupConverter groupConverter;
  private final GroupRepository groupRepository;

  public List<ChangeDTO> getAllChanges(GroupEntity groupEntity) {
    Map<LocalDateTime, ChangeDTO> changeMap = Maps.newHashMap();
    putAllChangesRecursive(groupEntity, changeMap);
    return new ArrayList<>(changeMap.values());
  }

  private void putAllChangesRecursive(GroupEntity groupEntity, Map<LocalDateTime, ChangeDTO> changeMap) {
    if (Objects.isNull(groupEntity) || CollectionUtils.isEmpty(groupEntity.getChangeList())) {
      return;
    }
      groupEntity.getChangeList().parallelStream()
              .map(change -> changeConverter.toDto(change))
              .forEach(change -> changeMap.put(change.getDateTime(), change));
    if (groupEntity.hasParent()) {
      putAllChangesRecursive(groupEntity.getParentGroup(), changeMap);
    }
  }

  public boolean delete(long id){
    if (Objects.nonNull(id) ) {
      groupRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public void save(GroupDTO groupDTO){
    if (!Objects.nonNull(groupDTO) ) {
      groupRepository.save(groupConverter.toEntity(groupDTO));
    }
  }

  public GroupDTO getGroup(long id) {
    if (Objects.nonNull(id) ) {
      throw new NullPointerException();
    }
    GroupEntity groupEntity = groupRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    return groupConverter.toDto(groupEntity);
  }

  public boolean update(GroupDTO groupDTO){
    if (!Objects.nonNull(groupDTO) ) {
      GroupEntity groupEntity = groupConverter.toEntity(groupDTO);
      groupRepository.getOne(groupDTO.getId()).setChangeList(groupEntity.getChangeList());
      groupRepository.getOne(groupDTO.getId()).setCreated(groupEntity.getCreated());
      groupRepository.getOne(groupDTO.getId()).setParentGroup(groupEntity.getParentGroup());
      groupRepository.getOne(groupDTO.getId()).setUserRoleList(groupEntity.getUserRoleList());
      groupRepository.getOne(groupDTO.getId()).setVisibility(groupEntity.getVisibility());
      return true;
    }
    return false;
  }

}
