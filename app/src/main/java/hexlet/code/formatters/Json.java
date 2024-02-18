package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Json {
    public static String make(LinkedList<Map<String, Object>> parsedList) throws JsonProcessingException {
        var json = new LinkedList<Map<String, Object>>();
        for (var valueMap : parsedList) {
            var valueJson = new LinkedHashMap<String, Object>();
            valueMap = setNull(valueMap);
            if (valueMap.get("diff_value").equals("added")) {
                valueJson.put("key", valueMap.get("master_key"));
                valueJson.put("status", valueMap.get("diff_value"));
                valueJson.put("value", valueMap.get("new_value"));
            }  else if (valueMap.get("diff_value").equals("deleted")) {
                valueJson.put("key", valueMap.get("master_key"));
                valueJson.put("status", valueMap.get("diff_value"));
                valueJson.put("value", valueMap.get("old_value"));
            } else if (valueMap.get("diff_value").equals("unchanged")) {
                valueJson.put("key", valueMap.get("master_key"));
                valueJson.put("status", valueMap.get("diff_value"));
                valueJson.put("value", valueMap.get("old_value"));
            } else if (valueMap.get("diff_value").equals("changed")) {
                valueJson.put("key", valueMap.get("master_key"));
                valueJson.put("status", "changed");
                valueJson.put("old_value", valueMap.get("old_value"));
                valueJson.put("new_value", valueMap.get("new_value"));
            }
            json.add(valueJson);

        }
        return new ObjectMapper().writeValueAsString(json);


    }
    private static Map<String, Object> setNull(Map<String, Object> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue() == "null") {
                entry.setValue(null);
            }
        }
        return map;
    }


}
