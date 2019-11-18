package student.enterprise.project.entity;

import lombok.*;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;
import student.enterprise.project.dto.enums.RepeatFrequency;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repeatable_changes")
public class RepeatableChangeEntity extends ChangeEntity {

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "repeat_date", columnDefinition = "DATE")
    private LocalDate repeatDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private RepeatFrequency frequency;

}
