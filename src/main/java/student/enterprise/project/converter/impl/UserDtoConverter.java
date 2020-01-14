package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractDtoConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;

@Converter
public class UserDtoConverter extends AbstractDtoConverter<UserEntity, UserDTO> {

    public UserDtoConverter(ModelMapper mapper) {
        super(UserEntity.class, mapper);
    }

}
