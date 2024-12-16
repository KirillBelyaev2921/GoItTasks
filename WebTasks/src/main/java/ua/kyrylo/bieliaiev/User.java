package ua.kyrylo.bieliaiev;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Override
  public String toString() {
    return "{"
        + "\"id\":\"" + id + "\""
        + ",\"name\":\"" + name + "\""
        + ",\"username\":\"" + username + "\""
        + ",\"email\":\"" + email + "\""
        + ",\"address\":" + address
        + ",\"phone\":\"" + phone + "\""
        + ",\"website\":\"" + website + "\""
        + ",\"company\":" + company
        + "}";
  }
}
