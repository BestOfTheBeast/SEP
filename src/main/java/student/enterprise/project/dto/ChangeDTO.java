package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeDTO {

    private Long id;

    private LessonDTO lessonDTO;

    private Long subjectId;

    private Long lecturerId;

    private LocalDate date;

    public LocalDateTime getDateTime() {
        return Objects.nonNull(date) && Objects.nonNull(getLessonDTO()) && Objects.nonNull(getLessonDTO().getTime())
                ? LocalDateTime.of(date, getLessonDTO().getTime())
                : null;
    }
}
