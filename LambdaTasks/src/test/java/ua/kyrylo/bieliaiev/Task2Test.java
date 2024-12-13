package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Task2Test {

  @Test
  void toUpperCaseReverseOrder() {
    Task2 task2 = new Task2();

    List<String> names = List.of("Ivan", "Sergey", "Peter", "Kyrylo", "Olexandr", "Sofia", "Daria");

    List<String> result = task2.toUpperCaseReverseOrder(names);

    assertEquals(List.of("SOFIA", "SERGEY", "PETER", "OLEXANDR", "KYRYLO", "IVAN", "DARIA"), result);
  }
}