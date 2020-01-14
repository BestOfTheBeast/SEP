package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;

@Converter
public class UserEntityConverter extends AbstractEntityConverter<UserEntity, UserDTO> {

    public UserEntityConverter(ModelMapper mapper) {
        super(UserDTO.class, mapper);
    }

}
