package ua.kyrylo.bieliaiev;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Task5Test {

  @Test
  void zip() {
    Task5.zip(Stream.of(1, 2, 3), Stream.of(4, 5, 6, 7, 8))
        .forEach(System.out::println);

  }

  @Test
  void zip2() {
    Task5.zip(Stream.of(1, 2, 3), Stream.of(4))
        .forEach(System.out::println);

  }

  @Test
  void zip3() {
    Task5.zip(Stream.of("I'm", " sure", " there's", " easier"),
            Stream.of(" not", " if", " an", " solution."))
        .forEach(System.out::println);

  }
}