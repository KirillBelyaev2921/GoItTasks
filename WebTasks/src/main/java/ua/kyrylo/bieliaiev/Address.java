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
public class Address {

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private GeoLocation geo;

  @Override
  public String toString() {
    return "{"
        + "\"street\":\"" + street + "\""
        + ",\"suite\":\"" + suite + "\""
        + ",\"city\":\"" + city + "\""
        + ",\"zipcode\":\"" + zipcode + "\""
        + ",\"geo\":" + geo
        + "}";
  }
}
