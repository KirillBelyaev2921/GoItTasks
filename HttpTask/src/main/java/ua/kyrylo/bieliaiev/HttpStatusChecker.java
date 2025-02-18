package ua.kyrylo.bieliaiev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    private final HttpClient client = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http.cat/" + code + ".jpg"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return request.uri().toString();
        } else {
            throw new IllegalArgumentException("Cat with code " + code + " is not found");
        }
    }
}
