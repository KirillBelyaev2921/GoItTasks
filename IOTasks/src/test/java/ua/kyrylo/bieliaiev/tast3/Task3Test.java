package ua.kyrylo.bieliaiev.tast3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import ua.kyrylo.bieliaiev.task3.Task3;

class Task3Test {

  @Test
  void countWordsFrequency() {
    Task3 task3 = new Task3();
    try {
      task3.countWordsFrequency(new FileInputStream("files/file3.txt"), System.out);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}