package student.enterprise.project.entity;

import lombok.*;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;
import student.enterprise.project.dto.enums.RepeatFrequency;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private RepeatFrequency frequency;

    @Override
    public LocalDateTime getDateTime() {
        //TODO define what date should be returned for repeatable change
        return null;
    }
}
