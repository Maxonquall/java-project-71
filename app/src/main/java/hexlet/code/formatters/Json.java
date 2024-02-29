package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Json {
    public static String make(List<Map<String, Object>> parsedList) throws JsonProcessingException {
        var json = new LinkedList<Map<String, Object>>();
        for (var valueMap : parsedList) {
            var valueJson = new LinkedHashMap<String, Object>();
            valueMap = setNull(valueMap);
            if (valueMap.get("diffValue").equals("added")) {
                valueJson.put("key", valueMap.get("masterKey"));
                valueJson.put("status", valueMap.get("diffValue"));
                valueJson.put("value", valueMap.get("newValue"));
            }  else if (valueMap.get("diffValue").equals("deleted")) {
                valueJson.put("key", valueMap.get("masterKey"));
                valueJson.put("status", valueMap.get("diffValue"));
                valueJson.put("value", valueMap.get("oldValue"));
            } else if (valueMap.get("diffValue").equals("unchanged")) {
                valueJson.put("key", valueMap.get("masterKey"));
                valueJson.put("status", valueMap.get("diffValue"));
                valueJson.put("value", valueMap.get("oldValue"));
            } else if (valueMap.get("diffValue").equals("changed")) {
                valueJson.put("key", valueMap.get("masterKey"));
                valueJson.put("status", "changed");
                valueJson.put("oldValue", valueMap.get("oldValue"));
                valueJson.put("newValue", valueMap.get("newValue"));
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
