package student.enterprise.project.entity;

import lombok.*;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "single_changes")
public class SingleChangeEntity extends ChangeEntity {

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    public LocalDateTime getDateTime() {
        return Objects.nonNull(date) && Objects.nonNull(getLessonEntity()) && Objects.nonNull(getLessonEntity().getTime())
                ? LocalDateTime.of(date, getLessonEntity().getTime())
                : null;
    }
}
