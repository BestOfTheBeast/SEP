package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.entity.LecturerEntity;
import student.enterprise.project.entity.LessonEntity;
import student.enterprise.project.entity.SubjectEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeDTO {

    private Long id;

    private LessonEntity lessonEntity;

    private SubjectEntity subjectEntity;

    private LecturerEntity lecturerEntity;

    private LocalDate date;

    public LocalDateTime getDateTime() {
        return Objects.nonNull(date) && Objects.nonNull(getLessonEntity()) && Objects.nonNull(getLessonEntity().getTime())
                ? LocalDateTime.of(date, getLessonEntity().getTime())
                : null;
    }
}
