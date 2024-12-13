package ua.kyrylo.bieliaiev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

  public String sortNumbers(List<String> numbers) {
    return numbers.stream()
        .flatMap(s -> Arrays.stream(s.split(", ")))
        .sorted()
        .collect(Collectors.joining(", "));
  }

}
