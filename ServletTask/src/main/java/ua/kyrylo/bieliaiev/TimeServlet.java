package ua.kyrylo.bieliaiev;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int offset = (Integer) req.getAttribute("offset");

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.ofHours(offset));
        String resultTime = now.format(formatter);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(resultTime);
    }
}
