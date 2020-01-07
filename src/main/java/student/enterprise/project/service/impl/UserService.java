package student.enterprise.project.service.impl;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.UserConverter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;
import student.enterprise.project.entity.UserPassword;
import student.enterprise.project.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Service
public class UserService {
  private UserRepository repository;
  private UserConverter converter;

  public void updateUser(long id, String password) {
    UserEntity userEntity = repository.getOne(id);
    UserPassword password = new UserPassword(/*id, new BCryptPasswordEncoder(password),salt*/);
    if (userEntity != null) {
      userEntity.setPassword(password);
      repository.save(userEntity);
    }
  }
  public List<UserDTO> getAll() {
    List<UserEntity> usersEntity = repository.findAll();
    return converter.toDto(usersEntity);
  }

  public void deleteUser(long userID) {
    if(repository.findById(userID) == null)
      throw new NullPointerException();
    repository.deleteById(userID);
  }

  public void save(UserDTO user) {
    repository.save(converter.toEntity(user));
  }

  public void create(long id, String login) {
   /* UserDTO userDTO = new UserDTO(id, login);
    repository.save(converter.toEntity(userDTO)); */
  }

  public UserDTO findById(long userID) {
      UserEntity userEntity = repository.findById(userID).orElseThrow(() -> new NullPointerException());
      return converter.toDto(userEntity);
  }

}
