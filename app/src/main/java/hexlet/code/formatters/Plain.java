package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.Map;
public class Plain {
    public static String make(LinkedList<Map<String, Object>> parsedList) {
        StringBuilder resultToString = new StringBuilder("");
        for (var valueMapRaw : parsedList) {
            var valueMap = replaceComplexValue(valueMapRaw);
            if (valueMap.get("diff_value").equals("added")) {
                resultToString.append("Property '" + valueMap.get("master_key") + "' was added with value: "
                        + valueMap.get("new_value")).append("\n");
            } else if (valueMap.get("diff_value").equals("deleted")) {
                resultToString.append("Property '" + valueMap.get("master_key") + "' was removed").append("\n");
            } else if (valueMap.get("diff_value").equals("changed")) {
                resultToString.append("Property '" + valueMap.get("master_key") + "' was updated. From "
                        + valueMap.get("old_value") + " to " + valueMap.get("new_value")).append("\n");
            }
        }
        return resultToString.toString().trim();
    }

    private static Map<String, Object> replaceComplexValue(Map<String, Object> map) {
        var key = map.get("master_key");
        if (map.get(key) instanceof String && !map.get(key).equals("null")) {
            map.put("new_value", "'" + map.get("new_value") + "'");
            map.put("old_value", "'" + map.get("old_value") + "'");
        }
        if (map.get("new_value").equals("'true'")) {
            map.put("new_value", "true");
        }
        if (map.get("old_value").equals("'true'")) {
            map.put("old_value", "true");
        }

        var newValue = map.get("new_value").toString();
        var oldValue = map.get("old_value").toString();
        if (newValue.contains("[") || newValue.contains("{")) {
            map.put("new_value", "[complex value]");
        }
        if (oldValue.contains("[") || oldValue.contains("{")) {
            map.put("old_value", "[complex value]");
        }

        return map;
    }
}

