package student.enterprise.project.utils;

public final class NumberUtil {

  //0 to get first bit and 15 to get the last one
  public static Boolean getBitAtPosition(short source, int position) {
    return ((source >> position) & 1) == 1;
  }

}
