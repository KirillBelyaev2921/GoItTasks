package ua.kyrylo.bieliaiev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http.cat/" + code + ".jpg"))
                .GET()
                .build();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return request.uri().toString();
            } else {
                throw new IllegalArgumentException("Cat with code " + code + " is not found");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
