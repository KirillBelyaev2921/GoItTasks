package ua.kyrylo.bieliaiev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeoLocation {

  private String lat;
  private String lng;

  @Override
  public String toString() {
    return "{"
        + "\"lat\":\"" + lat + "\""
        + ",\"lng\":\"" + lng + "\""
        + "}";
  }
}
