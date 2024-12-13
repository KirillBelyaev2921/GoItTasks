package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Task4Test {

  @Test
  void getRandomLongStream() {
    Task4 task4 = new Task4();

    task4.getRandomLongStream(25214903917L, 11L, 1L << 48)
        .limit(10)
        .forEach(System.out::println);
  }
}