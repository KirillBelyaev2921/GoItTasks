package ua.kyrylo.bieliaiev.task1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class Task1Test {

  @Test
  void printValidNumbers() {
    Task1 task1 = new Task1();
    try {
      task1.printValidNumbers(new File("files/file.txt"), System.out);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("I/O error");
    }
  }
}