package ua.kyrylo.bieliaiev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {

    @Test
    void getStatusImage() throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();

        String statusImage = checker.getStatusImage(200);
        assertEquals("https://http.cat/200.jpg", statusImage);
    }

    @Test
    void getStatusImageWhenNotFound() {
        HttpStatusChecker checker = new HttpStatusChecker();

        assertThrows(IllegalArgumentException.class, () -> checker.getStatusImage(1000));
    }

    @Test
    void getStatusImageWhen404() throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();

        String statusImage = checker.getStatusImage(404);
        assertEquals("https://http.cat/404.jpg", statusImage);
    }
}