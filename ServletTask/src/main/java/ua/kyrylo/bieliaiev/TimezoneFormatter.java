package ua.kyrylo.bieliaiev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimezoneFormatter {

    private static final Pattern TIMEZONE_PATTERN = Pattern.compile("UTC[ +]?(-?\\d+)");

    private TimezoneFormatter() {
    }

    public static int getTimezoneOffset(String timezone) {
        int offset = 0;
        if (timezone != null) {
            Matcher matcher = TIMEZONE_PATTERN.matcher(timezone);
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
