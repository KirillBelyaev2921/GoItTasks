package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class Task3Test {

  @Test
  void sortNumbers1() {
    Task3 task3 = new Task3();

    List<String> number = List.of("1, 2, 0", "4, 5");

    String result = task3.sortNumbers(number);

    assertEquals("0, 1, 2, 4, 5", result);
  }

  @Test
  void sortNumbers2() {
    Task3 task3 = new Task3();

    List<String> number = List.of("11, 22, 0", "44, 45", "10, 13, 1");

    String result = task3.sortNumbers(number);

    assertEquals("0, 1, 10, 11, 13, 22, 44, 45", result);
  }
}