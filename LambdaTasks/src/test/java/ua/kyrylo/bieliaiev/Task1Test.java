package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class Task1Test {

  @Test
  void getZeroBasedOddNames() {
    Task1 task1 = new Task1();

    List<String> names = List.of("Ivan", "Sergey", "Peter", "Kyrylo", "Olexandr", "Sofia", "Daria");

    String result = task1.getZeroBasedOddNames(names);

    assertEquals("1. Sergey, 3. Kyrylo, 5. Sofia", result);
  }

  @Test
  void getOneBasedOddNames() {
    Task1 task1 = new Task1();

    List<String> names = List.of("Ivan", "Sergey", "Peter", "Kyrylo", "Olexandr", "Sofia", "Daria");

    String result = task1.getOneBasedOddNames(names);

    assertEquals("1. Ivan, 3. Peter, 5. Olexandr, 7. Daria", result);
  }
}