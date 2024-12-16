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
public class Company {

  private String name;
  private String catchPhrase;
  private String bs;

  @Override
  public String toString() {
    return "{"
        + "\"name\":\"" + name + "\""
        + ",\"catchPhrase\":\"" + catchPhrase + "\""
        + ",\"bs\":\"" + bs + "\""
        + "}";
  }
}
