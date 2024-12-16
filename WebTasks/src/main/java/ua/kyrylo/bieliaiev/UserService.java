package ua.kyrylo.bieliaiev;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
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

  private static final String url = "https://jsonplaceholder.typicode.com";
  private static final Pattern ids = Pattern.compile("\"id\": (\\d+)");

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

  public String getUsers() throws IOException, ParseException {

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(url + "/users");

      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  public String getUserById(int id) throws IOException, ParseException {

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(url + "/users/" + id);

      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  public String getUserByUserName(String username) throws IOException, ParseException {

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(url + "/users?username=" + username);

      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  public void saveLastPostCommentsToFile(int userId) throws IOException, ParseException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      int maxPostId = getMaxPost(httpClient, userId);

      String content = getPostComments(maxPostId, httpClient);

      System.out.println(content);

      writeContentToFile(userId, maxPostId, content);
    }

  }

  public void printOpenTasksForUser(int userId) throws IOException, ParseException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(url + "/users/" + userId + "/todos?completed=false");

      try (CloseableHttpResponse response = httpClient.execute(request)) {
        if (response.getEntity() != null) {
          System.out.println(
              EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
        } else {
          throw new IOException("Empty response from server");
        }
      }
    }
  }

  private int getMaxPost(CloseableHttpClient httpClient, int userId)
      throws IOException, ParseException {

    HttpGet request = new HttpGet(url + "/users/" + userId + "/posts");
    try (CloseableHttpResponse response = httpClient.execute(request)) {
      if (response.getEntity() != null) {
        String content = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        return  ids.matcher(content)
            .results()
            .map(matchResult -> matchResult.group(1))
            .mapToInt(Integer::parseInt)
            .max()
            .orElseThrow();
      } else {
        throw new IOException("Empty response from server");
      }
    }
  }

  private String getPostComments(int maxPost, CloseableHttpClient httpClient)
      throws IOException, ParseException {

    HttpGet request = new HttpGet(url + "/posts/" + maxPost + "/comments");
    try (CloseableHttpResponse response = httpClient.execute(request)) {
      if (response.getEntity() != null) {
        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
      } else {
        throw new IOException("Empty response from server");
      }
    }
  }

  private void writeContentToFile(int userId, int postId, String content) throws IOException {

    try (BufferedWriter out = new BufferedWriter(
        new FileWriter("files/user-%d-post-%d-comments.json".formatted(userId, postId)))) {

      out.write(content);
    }
  }

}
