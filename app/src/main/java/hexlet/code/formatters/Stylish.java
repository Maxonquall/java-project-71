package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String make(List<Map<String, Object>> parsedList) {
        StringBuilder resultToString = new StringBuilder("{\n");

        for (var valueMap : parsedList) {

            if (valueMap.get("diffValue").equals("added")) {
                resultToString.append("  + " + valueMap.get("masterKey") + ": "
                        + valueMap.get("newValue")).append("\n");
            } else if (valueMap.get("diffValue").equals("deleted")) {
                resultToString.append("  - " + valueMap.get("masterKey") + ": "
                        + valueMap.get("oldValue")).append("\n");
            } else if (valueMap.get("diffValue").equals("unchanged")) {
                resultToString.append("    " + valueMap.get("masterKey") + ": "
                        + valueMap.get("oldValue")).append("\n");
            } else {
                resultToString.append("  - " + valueMap.get("masterKey") + ": "
                        + valueMap.get("oldValue")).append("\n");
                resultToString.append("  + " + valueMap.get("masterKey") + ": "
                        + valueMap.get("newValue")).append("\n");
            }
        }
        resultToString.append("}");
        return resultToString.toString();
    }

}
