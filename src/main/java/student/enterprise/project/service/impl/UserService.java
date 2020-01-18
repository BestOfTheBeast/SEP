package student.enterprise.project.service.impl;

import lombok.RequiredArgsConstructor;
import student.enterprise.project.converter.impl.UserConverter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;
import student.enterprise.project.repository.UserRepository;
import student.enterprise.project.service.CRUDService;

import java.util.List;

@RequiredArgsConstructor
public class UserService implements CRUDService<UserDTO> {

  private UserRepository repository;
  private UserConverter converter;

  @Override
  public UserDTO update(UserDTO userToUpdate) {
    UserEntity userEntity = repository.getOne(userToUpdate.getId());
    userEntity.setLogin(userToUpdate.getLogin());
    repository.save(userEntity);
    return converter.toDto(userEntity);
  }

  @Override
  public List<UserDTO> getAll() {
    List<UserEntity> usersEntity = repository.findAll();
    return converter.toDto(usersEntity);
  }

  @Override
  public void delete(Long userID) {
    if (!repository.findById(userID).isPresent()) {
      throw new NullPointerException();
    }
    repository.deleteById(userID);
  }

  @Override
  public UserDTO create(UserDTO user) {
    UserEntity userEntity = repository.save(converter.toEntity(user));
    return converter.toDto(userEntity);
  }

  @Override
  public UserDTO get(Long userID) {
    UserEntity userEntity = repository.findById(userID).orElseThrow(NullPointerException::new);
    return converter.toDto(userEntity);
  }

}
