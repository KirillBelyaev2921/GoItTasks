package ua.kyrylo.bieliaiev;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {

  public String getZeroBasedOddNames(List<String> names) {
    return IntStream.range(0, names.size())
        .filter(i -> i % 2 == 1)
        .mapToObj(i -> i + ". " + names.get(i))
        .collect(Collectors.joining(", "));
  }

  public String getOneBasedOddNames(List<String> names) {
    return IntStream.range(0, names.size())
        .filter(i -> i % 2 == 0)
        .mapToObj(i -> (i + 1) + ". " + names.get(i))
        .collect(Collectors.joining(", "));
  }
}
