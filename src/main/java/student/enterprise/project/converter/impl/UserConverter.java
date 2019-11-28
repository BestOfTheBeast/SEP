package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;

import java.util.stream.Collectors;

@Converter
public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

    private GroupConverter groupConverter;

    public UserConverter(ModelMapper mapper, GroupConverter groupConverter) {
        super(UserEntity.class, UserDTO.class, mapper);
        this.groupConverter = groupConverter;
    }

    @Override
    public UserDTO toDto(UserEntity entity) {
        return UserDTO.builder()
            .id(entity.getId())
            .login(entity.getLogin())
            .groupList(entity.getGroupRoleList().stream()
                .map(groupRole -> groupConverter.toDto(groupRole.getGroup()))
                .collect(Collectors.toList()))
            .build();
    }
}
