package student.enterprise.project.utils;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public final class DateUtil {

  //Returns 0 if it's a Monday of the first week and 13 if Sunday of the second
  public static Integer getDayOfTwoWeeks(LocalDate localDate) {
    return (localDate.getDayOfWeek().getValue() - 1) + 7 * getWeekNumber(localDate);
  }

  //0 if first week, 1 if second
  public static Integer getWeekNumber(LocalDate localDate) {
    final WeekFields wf = WeekFields.of(Locale.getDefault());
    return localDate.get(wf.weekOfWeekBasedYear()) % 2;
  }

}
