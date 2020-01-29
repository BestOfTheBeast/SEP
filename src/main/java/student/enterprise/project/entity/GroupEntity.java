package student.enterprise.project.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

/*
  Group entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kpi_groups")
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

  @Column(name = "is_public")
  private Boolean isPublic;

  @Convert(converter = LocalDateAttributeConverter.class)
  @Column(name = "created", columnDefinition = "TIMESTAMP")
  private LocalDateTime created;

  public Boolean hasParent() {
    return Objects.nonNull(parentGroup);
  }

}
