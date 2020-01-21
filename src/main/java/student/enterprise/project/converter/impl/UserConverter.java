package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;

@Converter
public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

    public UserConverter(ModelMapper mapper) {
        super(UserEntity.class, UserDTO.class, mapper);
    }

}
