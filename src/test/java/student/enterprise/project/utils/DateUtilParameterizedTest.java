package student.enterprise.project.utils;

import static org.assertj.core.api.Java6Assertions.assertThat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateUtilParameterizedTest {

  private LocalDate givenDate;
  private Integer expectedResult;

  public DateUtilParameterizedTest(LocalDate givenDate, Integer expectedResult) {
    this.givenDate = givenDate;
    this.expectedResult = expectedResult;
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{

            //0   15 September 2019 = Friday of first week = 4
            {LocalDate.of(2019, 11, 15), 4},
            //1   18 December 2019 = Wednesday of second week = 9
            {LocalDate.of(2019, 12, 18), 9},
            //2   3 January 2020 = Friday of second week = 11
            {LocalDate.of(2020, 1, 3), 11},
        }
    );
  }

  @Test
  public void shouldGetDayOfTwoWeeks() {
    //When
    final Integer result = DateUtil.getDayOfTwoWeeks(givenDate);

    //Then
    assertThat(result).isEqualTo(expectedResult);
  }

}
