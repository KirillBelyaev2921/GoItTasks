package ua.kyrylo.bieliaiev.task1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class Task1 {

  private static final Pattern pattern =
      Pattern.compile("(([(]\\d{3}[)] \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4}))");

  public void printValidNumbers(File file, PrintStream out) throws IOException {
    Files.lines(file.toPath())
        .filter(s -> pattern.matcher(s).matches())
        .forEach(out::println);
  }

}
