package student.enterprise.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repeatable_changes_view")
public class RepeatableChangeEntity extends ChangeEntity {
	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "start_date", columnDefinition = "DATE")
	private LocalDate startDate;

	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "end_date", columnDefinition = "DATE")
	private LocalDate endDate;

	/**
	 * Represents a 16 bit number in decimal system, where firs 14 bits are days of
	 * two week, the fourteenth and fifteenth bits should be always zero, and each 1
	 * describe a presence of this change in that day.
	 */
	@Column(name = "two_week_flag")
	private Short twoWeekFlag;
}
