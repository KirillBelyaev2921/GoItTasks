package ua.kyrylo.bieliaiev;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class UserService {

  String url = "https://jsonplaceholder.typicode.com";

  public String addUser(User user) throws IOException, ParseException {

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpPost request = new HttpPost(url + "/users");
      StringEntity entity = new StringEntity(user.toString(), ContentType.APPLICATION_JSON);

      request.setEntity(entity);

      request.setHeader("Accept", "application/json");
      request.setHeader("Content-type", "application/json");
      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  public String updateUser(User user) throws IOException, ParseException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpPut request = new HttpPut(url + "/users/" + user.getId());
      StringEntity entity = new StringEntity(user.toString(), ContentType.APPLICATION_JSON);

      request.setEntity(entity);

      request.setHeader("Accept", "application/json");
      request.setHeader("Content-type", "application/json");
      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  public int deleteUser(int id) throws IOException, ParseException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpDelete request = new HttpDelete(url + "/users/" + id);

      try (CloseableHttpResponse response = httpClient.execute(request)) {
        return response.getCode();
      }
    }
  }

}
