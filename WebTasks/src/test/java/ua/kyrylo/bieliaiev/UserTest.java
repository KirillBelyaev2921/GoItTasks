package ua.kyrylo.bieliaiev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void testToString() {
    User user = User.builder()
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

    System.out.println(user);
  }
}