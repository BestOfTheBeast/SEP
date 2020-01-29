package student.enterprise.project.utils;

import static org.assertj.core.api.Java6Assertions.assertThat;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumberUtilParameterizedTest {

  private Short givenShort;
  private Integer givenPosititon;
  private Boolean expectedResult;

  public NumberUtilParameterizedTest(Short givenShort, Integer givenPosititon, Boolean expectedResult) {
    this.givenShort = givenShort;
    this.givenPosititon = givenPosititon;
    this.expectedResult = expectedResult;
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{

            //0
            {(short) 0, 0, false},
            //1
            {(short) 1, 0, true},
            //2
            {(short) 2, 0, false},
            //3
            {(short) 2, 1, true},
            //4
            {(short) 3, 0, true},
            //5
            {(short) 3, 1, true},
            //6   10d = 0000 0000 0000 1010b
            {(short) 10, 0, false},
            //7
            {(short) 10, 1, true},
            //8
            {(short) 10, 2, false},
            //9
            {(short) 10, 3, true},
            //10   1337d = 0000 0101 0011 1001b
            {(short) 1337, 0, true},
            //11
            {(short) 1337, 3, true},
            //12
            {(short) 1337, 4, true},
            //13
            {(short) 1337, 5, true},
            //14
            {(short) 1337, 8, true},
            //15
            {(short) 1337, 10, true},
            //16
            {(short) 1337, 11, false},
        }
    );
  }

  @Test
  public void shouldGetBitAtPosition() {
    //When
    final Boolean result = NumberUtil.getBitAtPosition(givenShort, givenPosititon);

    //Then
    assertThat(result).isEqualTo(expectedResult);
  }
}
