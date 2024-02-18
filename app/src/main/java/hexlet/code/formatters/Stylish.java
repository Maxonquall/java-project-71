package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.Map;

public class Stylish {
    public static String make(LinkedList<Map<String, Object>> parsedList) {
        StringBuilder resultToString = new StringBuilder("{\n");

        for (var valueMap : parsedList) {
            if (valueMap.get("diff_value").equals("added")) {
                resultToString.append("  + " + valueMap.get("master_key") + ": "
                        + valueMap.get("new_value")).append("\n");
            } else if (valueMap.get("diff_value").equals("deleted")) {
                resultToString.append("  - " + valueMap.get("master_key") + ": "
                        + valueMap.get("old_value")).append("\n");
            } else if (valueMap.get("diff_value").equals("unchanged")) {
                resultToString.append("    " + valueMap.get("master_key") + ": "
                        + valueMap.get("old_value")).append("\n");
            } else {
                resultToString.append("  - " + valueMap.get("master_key") + ": "
                        + valueMap.get("old_value")).append("\n");
                resultToString.append("  + " + valueMap.get("master_key") + ": "
                        + valueMap.get("new_value")).append("\n");
            }
        }
        resultToString.append("}");
        return resultToString.toString();
    }
}
