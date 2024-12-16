package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}