package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  private final UserService userService = new UserService();
  private final User user = User.builder()
      .id(1)
      .name("Leanne Graham")
      .username("Bret")
      .email("123@gmail.com")
      .address(Address.builder()
          .street("Kulas light")
          .suite("Apt. 556")
          .city("Gwen")
          .zipcode("92998-3874")
          .geo(new GeoLocation("-37.3159", "81.1496"))
          .build())
      .phone("-770-736-8031 x56442")
      .website("hildegard.org")
      .company(Company.builder()
          .name("Romaguera-Crona")
          .catchPhrase("Multi-layered client-server neural-net")
          .bs("harness real-time e-markets")
          .build())
      .build();


  @Test
  void addUser() throws IOException, ParseException {
    String response = userService.addUser(user);

    assertNotNull(response);
    assertTrue(response.contains("\"id\": 11"));
  }

  @Test
  void updateUser() throws IOException, ParseException {
    String response = userService.updateUser(user);

    assertNotNull(response);
    assertTrue(response.contains("\"id\": 1"));
    assertTrue(response.contains("\"email\": \"123@gmail.com\""));
  }

  @Test
  void deleteUser() throws IOException, ParseException {
    int codeResponse = userService.deleteUser(1);

    assertEquals(2, codeResponse / 100);
  }

  @Test
  void getUsers() throws IOException, ParseException {
    String users = userService.getUsers();
    System.out.println(users);

    assertTrue(users.contains("\"id\": 1"));
    assertTrue(users.contains("\"id\": 10"));
    assertTrue(users.contains("\"website\": \"jacynthe.com\""));
  }

  @Test
  void getUserById() throws IOException, ParseException {
    String user = userService.getUserById(1);
    System.out.println(user);

    assertTrue(user.contains("\"id\": 1"));
    assertFalse(user.contains("\"id\": 10"));
  }

  @Test
  void getUserByIdNoPresent() throws IOException, ParseException {
    String user = userService.getUserById(11);

    assertEquals("{}", user);
  }

  @Test
  void getUserByUserName() throws IOException, ParseException {
    String user = userService.getUserByUserName("Bret");
    System.out.println(user);

    assertTrue(user.contains("\"id\": 1"));
    assertTrue(user.contains("\"username\": \"Bret\""));
  }

  @Test
  void getUserByUserNameNoPresent() throws IOException, ParseException {
    String user = userService.getUserByUserName("Bret2");

    assertEquals("[]", user);
  }

  @Test
  void saveLastPostCommentsToFile() throws IOException, ParseException {
    userService.saveLastPostCommentsToFile(1);
  }

  @Test
  void saveLastPostCommentsToFile2() throws IOException, ParseException {
    userService.saveLastPostCommentsToFile(2);
  }

  @Test
  void printOpenTasksForUser() throws IOException, ParseException {
    userService.printOpenTasksForUser(1);
  }
}