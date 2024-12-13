package ua.kyrylo.bieliaiev;

import java.util.Comparator;
import java.util.List;

public class Task2 {

  public List<String> toUpperCaseReverseOrder(List<String> list) {
    return list.stream()
        .map(String::toUpperCase)
        .sorted(Comparator.reverseOrder())
        .toList();
  }

}
