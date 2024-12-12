package ua.kyrylo.bieliaiev.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Task2 {

  private static final Pattern pattern =
      Pattern.compile("(([(]\\d{3}[)] \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4}))");

  public void transformUserDataToJson(BufferedReader reader, BufferedWriter out) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    String line = reader.readLine(); // header
    List<User> users = new ArrayList<>();
    while ((line = reader.readLine()) != null) {
      String[] splitLine = line.split(" ");
      String name = splitLine[0];
      int age = Integer.parseInt(splitLine[1]);

      users.add(new User(name, age));
    }

    String json = gson.toJson(users);
    out.write(json);
    out.flush();
  }

}
