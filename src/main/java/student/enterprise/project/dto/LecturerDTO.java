package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.dto.enums.LecturerDegree;
import student.enterprise.project.entity.ChangeEntity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDTO {

    private Long id;

    private List<ChangeEntity> lessonList;

    private String name;

    private String surname;

    private String secondName;

    private LecturerDegree degree;

}
