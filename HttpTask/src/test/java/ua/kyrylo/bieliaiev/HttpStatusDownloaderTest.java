package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HttpStatusDownloaderTest {

    @Test
    void downloadStatusImage() throws Exception {
        HttpStatusDownloader downloader = new HttpStatusDownloader("cats/");

        downloader.downloadStatusImage(200);
        System.out.println(Path.of("cats/200.jpg").toAbsolutePath());
        assertTrue(Files.exists(Path.of("cats/200.jpg")));
    }
    @Test
    void downloadStatusImage2() throws Exception {
        HttpStatusDownloader downloader = new HttpStatusDownloader("cats/");

        downloader.downloadStatusImage(400);
        assertTrue(Files.exists(Path.of("cats/400.jpg")));
    }
    @Test
    void downloadStatusImageWhenNotFound() {
        HttpStatusDownloader downloader = new HttpStatusDownloader("cats/");

        assertThrows(IllegalArgumentException.class, () -> downloader.downloadStatusImage(2000));
    }
}