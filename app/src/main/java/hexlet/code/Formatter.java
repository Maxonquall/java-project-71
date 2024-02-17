package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.LinkedList;
import java.util.Map;

public class Formatter {
    public static String format(LinkedList<Map<String, Object>> parsedList, String style) {
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
