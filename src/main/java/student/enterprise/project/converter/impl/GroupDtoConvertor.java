package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractDtoConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.entity.GroupEntity;

@Converter
public class GroupDtoConvertor extends AbstractDtoConverter<GroupEntity, GroupDTO> {
    public GroupDtoConvertor(Class<GroupEntity> groupEntityClass, ModelMapper mapper) {
        super(groupEntityClass, mapper);
    }
}
