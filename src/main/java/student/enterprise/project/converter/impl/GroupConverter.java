package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;

@Converter
public class GroupConverter extends AbstractConverter<GroupEntity, GroupDTO> {

  public GroupConverter(ModelMapper mapper) {
    super(GroupEntity.class, GroupDTO.class, mapper);
  }
}
