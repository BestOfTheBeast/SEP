package student.enterprise.project.entity;

import lombok.*;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "repeat_date")
    private Short repeatDate;

}
