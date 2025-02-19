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

    @Override
    public void doFilter(HttpServletRequest req,
                         HttpServletResponse res,
                         FilterChain chain)
            throws IOException, ServletException {

        String timezone = req.getParameter("timezone");
        try {
            int offset = TimezoneFormatter.getTimezoneOffset(timezone);
            req.setAttribute("offset", offset);
            chain.doFilter(req, res);
        } catch (IllegalArgumentException e) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("Invalid timezone: " + timezone);
            res.getWriter().close();
        }
    }
}
