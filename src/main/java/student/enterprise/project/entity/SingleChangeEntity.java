package student.enterprise.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "single_changes_view")
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
