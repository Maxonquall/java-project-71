package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
public class Plain {
    public static String make(List<Map<String, Object>> parsedList) {
        StringBuilder resultToString = new StringBuilder("");
        for (var valueMapRaw : parsedList) {
            var valueMap = replaceComplexValue(valueMapRaw);
            if (valueMap.get("diffValue").equals("added")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was added with value: "
                        + valueMap.get("newValue")).append("\n");
            } else if (valueMap.get("diffValue").equals("deleted")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was removed").append("\n");
            } else if (valueMap.get("diffValue").equals("changed")) {
                resultToString.append("Property '" + valueMap.get("masterKey") + "' was updated. From "
                        + valueMap.get("oldValue") + " to " + valueMap.get("newValue")).append("\n");
            }
        }
        return resultToString.toString().trim();
    }

    private static Map<String, Object> replaceComplexValue(Map<String, Object> map) {
        var key = map.get("masterKey");
        if (map.get(key) instanceof String && !map.get(key).equals("null")) {
            map.put("newValue", "'" + map.get("newValue") + "'");
            map.put("oldValue", "'" + map.get("oldValue") + "'");
        }

        if (map.get("newValue") != null && map.get("newValue").equals("'true'")) {
            map.put("newValue", "true");
        }

        if (map.get("oldValue") != null && map.get("oldValue").equals("'true'")) {
            map.put("oldValue", "true");
        }
        var newValue = map.get("newValue") != null ? map.get("newValue").toString() : "";
        var oldValue = map.get("oldValue") != null ? map.get("oldValue").toString() : "";

        if (newValue != null && (newValue.contains("[") || newValue.contains("{"))) {
            map.put("newValue", "[complex value]");
        }

        if (oldValue != null && (oldValue.contains("[") || oldValue.contains("{"))) {
            map.put("oldValue", "[complex value]");
        }
        return map;
    }
}


