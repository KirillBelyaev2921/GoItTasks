package ua.kyrylo.bieliaiev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO");
    private static final Pattern timezonePattern = Pattern.compile("UTC[ +]?(-?\\d+)");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timezone = req.getParameter("timezone");
        int offset = 0;
        if (timezone != null) {
            Matcher matcher = timezonePattern.matcher(timezone);
            if (matcher.find()) {
                offset = Integer.parseInt(matcher.group(1));
            } else {
                throw new ServletException("Invalid timezone: " + timezone);
            }
        }
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.ofHours(offset));
        String resultTime = now.format(formatter);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(resultTime);
    }
}
