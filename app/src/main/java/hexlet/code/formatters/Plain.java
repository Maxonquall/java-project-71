package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
public class Plain {
    public static String format(List<Map<String, Object>> parsedList) {
        StringBuilder resultToString = new StringBuilder();
        for (var valueMap : parsedList) {
            if (valueMap.get("diffValue").equals("added")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was added with value: "
                        + fixValue(valueMap.get("newValue"))).append("\n");
            } else if (valueMap.get("diffValue").equals("deleted")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was removed").append("\n");
            } else if (valueMap.get("diffValue").equals("changed")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was updated. From "
                        + fixValue(valueMap.get("oldValue")) + " to "
                        + fixValue(valueMap.get("newValue"))).append("\n");
            }
        }
        return resultToString.toString().trim();
    }

    private static String fixValue(Object value) {
        if (value == null) {
            return "null";
        } else if ((value.toString().contains("[") || value.toString().contains("{"))) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}




