package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.LinkedList;
import java.util.Map;

public class Formatter {
    public static String format(LinkedList<Map<String, Object>> parsedList, String style)
            throws JsonProcessingException {
        switch (style) {
            case "plain" -> {
                return Plain.make(parsedList);
            }
            case "json" -> {
                return Json.make(parsedList);
            }
            default -> {
                return Stylish.make(parsedList);
            }
        }

    }
}
