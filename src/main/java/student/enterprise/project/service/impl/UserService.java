package student.enterprise.project.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.UserDtoConverter;
import student.enterprise.project.converter.impl.UserEntityConverter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;
import student.enterprise.project.repository.UserRepository;
import student.enterprise.project.service.CRUDService;

@Service
@RequiredArgsConstructor
public class UserService implements CRUDService<UserDTO> {

  private UserRepository repository;
  private UserEntityConverter userEntityConverter;
  private UserDtoConverter userDtoConverter;

  @Override
  public UserDTO update(UserDTO userToUpdate) {
    UserEntity userEntity = repository.getOne(userToUpdate.getId());
    userEntity.setLogin(userToUpdate.getLogin());
    repository.save(userEntity);
    return userEntityConverter.toDto(userEntity);
  }

  @Override
  public List<UserDTO> getAll() {
    List<UserEntity> usersEntity = repository.findAll();
    return userEntityConverter.toDto(usersEntity);
  }

  @Override
  public void delete(long userID) {
    if (!repository.findById(userID).isPresent()) {
      throw new NullPointerException();
    }
    repository.deleteById(userID);
  }

  @Override
  public UserDTO create(UserDTO user) {
    UserEntity userEntity = repository.save(userDtoConverter.toEntity(user));
    return userEntityConverter.toDto(userEntity);
  }

  @Override
  public UserDTO get(long userID) {
    UserEntity userEntity = repository.findById(userID).orElseThrow(() -> new NullPointerException());
    return userEntityConverter.toDto(userEntity);
  }

}
