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

    /**
     * Represents a 16 bit number in decimal system,
     * where firs 14 bits are days of two week,
     * the fourteenth and fifteenth bits should be always zero,
     * and each 1 describe a presence of this change in that day.
     */
    @Column(name = "two_week_flag")
    private Short twoWeekFlag;

}
