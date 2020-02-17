package student.enterprise.project.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.dto.enums.GroupVisibility;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Long id;

    private GroupDTO parentGroup;

    private List<ChangeDTO> changeList;

    private GroupVisibility visibility;

    private LocalDateTime created;

}
