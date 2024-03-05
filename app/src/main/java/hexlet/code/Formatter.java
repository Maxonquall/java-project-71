package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> parsedList, String style)
            throws JsonProcessingException {
        switch (style) {
            case  "stylish" -> {
                return Stylish.format(parsedList);
            }
            case "plain" -> {
                return Plain.format(parsedList);
            }
            case "json" -> {
                return Json.format(parsedList);
            }
            default -> throw new IllegalArgumentException("Wrong formatter type");
        }

    }
}
