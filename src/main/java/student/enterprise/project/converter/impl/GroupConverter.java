package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;

import java.util.Objects;
import java.util.stream.Collectors;

@Converter
public class GroupConverter extends AbstractConverter<GroupEntity, GroupDTO> {

  private final ChangeConverter changeConverter;
  public GroupConverter(ModelMapper mapper, ChangeConverter changeConverter) {
    super(GroupEntity.class, GroupDTO.class, mapper);
    this.changeConverter = changeConverter;
  }

  @Override
  public GroupDTO toDto(GroupEntity groupEntity){
    return GroupDTO.builder().id(groupEntity.getId())
            .changeList(groupEntity.getChangeList()
                    .stream()
                    .map(o -> changeConverter.toDto(o))
                    .collect(Collectors.toList()))
            .id(groupEntity.getId())
            .parentGroup(groupEntity.hasParent()? toDto(groupEntity.getParentGroup()) : null) //recursive
            .created(groupEntity.getCreated())
            .visibility(groupEntity.getVisibility())
            .build();
  }

  @Override
  public GroupEntity toEntity(GroupDTO groupDTO){
    return GroupEntity.builder()
            .parentGroup(Objects.nonNull(groupDTO)?toEntity(groupDTO) : null )
            .created(groupDTO.getCreated())
            .changeList(groupDTO.getChangeList()
                    .stream()
                    .map(o -> changeConverter.toEntity(o))
                    .collect(Collectors.toList()))
            .id(groupDTO.getId())
            //        .userRoleList(groupDTO.)   надо уточнить
            .visibility(groupDTO.getVisibility()).build();
  }
}
