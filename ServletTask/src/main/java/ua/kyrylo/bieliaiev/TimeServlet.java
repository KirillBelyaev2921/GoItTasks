package ua.kyrylo.bieliaiev;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    private TemplateEngine engine;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO");

    @Override
    public void init() {
        engine = new TemplateEngine();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.setTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String timezone = getTimezone(req);
        int offset = TimezoneFormatter.getTimezoneOffset(timezone);

        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.ofHours(offset));
        String resultTime = now.format(formatter);

        setResponse(req, resp, resultTime, timezone);
    }

    private String getTimezone(HttpServletRequest req) {
        String timezone = req.getParameter("timezone");

        if (timezone == null || timezone.isEmpty()) {
            String lastTimezone = getCookie(req, "lastTimezone");
            timezone = lastTimezone == null || lastTimezone.isEmpty()
                    ? null
                    : lastTimezone;
        }
        return timezone;
    }

    private String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(name))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);
    }

    private void setResponse(HttpServletRequest req, HttpServletResponse resp, String resultTime, String timezone) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        WebContext ctx = new WebContext(JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp));
        ctx.setVariable("time", resultTime);
        if (timezone != null) {
            resp.addCookie(new Cookie("lastTimezone", timezone));
        }
        engine.process("time", ctx, resp.getWriter());
    }
}
