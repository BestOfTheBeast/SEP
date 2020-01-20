package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;

@Converter
public class GroupEntityConverter extends AbstractEntityConverter<GroupEntity, GroupDTO> {

  public GroupEntityConverter(ModelMapper mapper) {
    super(GroupDTO.class, mapper);
  }
}
