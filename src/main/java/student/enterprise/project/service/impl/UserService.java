package student.enterprise.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.UserConverter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;
import student.enterprise.project.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private UserRepository repository;
  private UserConverter converter;

  public UserDTO updateUser(UserDTO userToUpdate) {
    UserEntity userEntity = repository.getOne(userToUpdate.getId());
    repository.save(userEntity);
    return converter.toDto(userEntity);
  }

  public List<UserDTO> getAll() {
    List<UserEntity> usersEntity = repository.findAll();
    return converter.toDto(usersEntity);
  }

  public void deleteUser(long userID) {
    if (repository.findById(userID).isPresent()) {
      throw new NullPointerException();
    }
    repository.deleteById(userID);
  }

  public UserDTO save(UserDTO user) {
    UserEntity userEntity = repository.save(converter.toEntity(user));
    return converter.toDto(userEntity);
  }

  public UserDTO findById(long userID) {
    UserEntity userEntity = repository.findById(userID).orElseThrow(() -> new NullPointerException());
    return converter.toDto(userEntity);
  }

}
