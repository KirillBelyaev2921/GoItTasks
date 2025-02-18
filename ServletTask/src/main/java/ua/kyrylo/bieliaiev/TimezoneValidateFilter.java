package ua.kyrylo.bieliaiev;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {

    private final TimezoneFormatter formatter = new TimezoneFormatter();

    @Override
    public void doFilter(HttpServletRequest req,
                         HttpServletResponse res,
                         FilterChain chain)
            throws IOException, ServletException {

        String timezone = req.getParameter("timezone");
        try {
            int offset = formatter.getTimezoneOffset(timezone);
            req.setAttribute("offset", offset);
            chain.doFilter(req, res);
        } catch (Exception e) {
            res.setStatus(400);
            res.getWriter().write("Invalid timezone: " + timezone);
            res.getWriter().close();
        }
    }
}
