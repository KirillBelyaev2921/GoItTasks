package ua.kyrylo.bieliaiev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimezoneFormatter {

    private static final Pattern timezonePattern = Pattern.compile("UTC[ +]?(-?\\d+)");

    public int getTimezoneOffset(String timezone) {
        int offset = 0;
        if (timezone != null) {
            Matcher matcher = timezonePattern.matcher(timezone);
            if (matcher.find()) {
                try {
                    offset = Integer.parseInt(matcher.group(1));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid timezone: " + timezone);
                }
            } else {
                throw new IllegalArgumentException("Invalid timezone: " + timezone);
            }
        }
        return offset;
    }
}
