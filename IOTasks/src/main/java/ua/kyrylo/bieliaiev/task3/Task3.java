package ua.kyrylo.bieliaiev.task3;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task3 {

  public void countWordsFrequency(InputStream in, PrintStream out) {
    Scanner sc = new Scanner(in);
    sc.useDelimiter("[^a-zA-Z]+");

    // PriorityQueue to sort result
    PriorityQueue<Map.Entry<String, Long>> pq
        = new PriorityQueue<>(Map.Entry.<String, Long>comparingByValue().reversed());

    // Group tokens and add entries to priority queue
    sc.tokens()
        .collect(groupingBy(String::toLowerCase, counting()))
        .entrySet().forEach(pq::add);

    // print out
    pq.stream()
        .map(e -> e.getKey() + " " + e.getValue())
        .forEach(out::println);

  }

}
