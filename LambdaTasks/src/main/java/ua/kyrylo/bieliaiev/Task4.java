package ua.kyrylo.bieliaiev;

import java.util.stream.Stream;

public class Task4 {

  private final static Long SEED = 1252915121258592L;

  public Stream<Long> getRandomLongStream(long a, long c, long m) {
    return Stream.iterate(SEED, i -> (a * i + c) % m);
  }
}
