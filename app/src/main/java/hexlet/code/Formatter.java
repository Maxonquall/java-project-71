package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<String> parsedList, String style) {
        switch (style) {
            case "plain" -> {
                return Plain.make(parsedList);
            }
            default -> {
                return Stylish.make(parsedList);
            }
        }

    }
}
