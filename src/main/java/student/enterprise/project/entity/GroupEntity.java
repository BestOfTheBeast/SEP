package student.enterprise.project.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;
import student.enterprise.project.dto.enums.GroupVisibility;

/*
  Group entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class GroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private GroupEntity parentGroup;

  @OneToMany
  @JoinColumn(name = "group_id", referencedColumnName = "id")
  private List<UserGroupEntity> userRoleList;

  @OneToMany
  @JoinColumn(name = "group_id", referencedColumnName = "id")
  private List<ChangeEntity> changeList;

  @Column(name = "visibility")
  private GroupVisibility visibility;

  @Convert(converter = LocalDateAttributeConverter.class)
  @Column(name = "created", columnDefinition = "DATE")
  private LocalDate created;

  public Boolean hasParent() {
    return Objects.nonNull(parentGroup);
  }

}
