package ua.kyrylo.bieliaiev.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Task2Test {

  @Test
  void txtUserToJson() {
    Task2 task2 = new Task2();
    try (BufferedReader in = new BufferedReader(new FileReader("files/file2_1_in.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("files/file2_1_out.txt"))) {
      task2.transformUserDataToJson(in, out);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("I/O error");
    }
  }
}