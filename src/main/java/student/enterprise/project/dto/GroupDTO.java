package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.dto.enums.GroupVisibility;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.GroupEntity;
import student.enterprise.project.entity.UserGroupEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Long id;

    private GroupEntity parentGroup;

    private List<UserGroupEntity> userRoleList;

    private List<ChangeEntity> changeList;

    private GroupVisibility visibility;

    private LocalDateTime created;

}
