package ua.kyrylo.bieliaiev;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusDownloader {

    private final String downloadFolderUrl;

    public HttpStatusDownloader(String downloadFolderUrl) {
        this.downloadFolderUrl = downloadFolderUrl;
    }

    public void downloadStatusImage(int code) {
        URI uri = URI.create(new HttpStatusChecker().getStatusImage(code));

        try (InputStream in = uri.toURL().openStream()) {
            Files.copy(in, Paths.get(downloadFolderUrl + code + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
