package hexlet.code;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Set;

public class Parser {
    public static String compare(Map<String, Object> map1Raw, Map<String, Object> map2Raw, String style) {
        var result = new LinkedList<Map<String, Object>>();
        var map1 = replaceNull(map1Raw);
        var map2 = replaceNull(map2Raw);
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            var valueMap = new HashMap<String, Object>();
            valueMap.put("master_key", key);
            if (!map1.containsKey(key)) {
                valueMap.put(key, map2.get(key));
                valueMap.put("diff_value", "added");
                valueMap.put("old_value", "null");
                valueMap.put("new_value", map2.get(key));
            } else if (!map2.containsKey(key)) {
                valueMap.put(key, map1.get(key));
                valueMap.put("diff_value", "deleted");
                valueMap.put("old_value", map1.get(key));
                valueMap.put("new_value", "null");
            } else if (map1.get(key).equals(map2.get(key))) {
                valueMap.put(key, map1.get(key));
                valueMap.put("diff_value", "unchanged");
                valueMap.put("old_value", map1.get(key));
                valueMap.put("new_value", map2.get(key));
            } else {
                valueMap.put(key, map2.get(key));
                valueMap.put("diff_value", "changed");
                valueMap.put("old_value", map1.get(key));
                valueMap.put("new_value", map2.get(key));
            }
            result.add(valueMap);
        }

        return Formatter.format(result, style);
    }


    private static Map<String, Object> replaceNull(Map<String, Object> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("null");
            }
        }
        return map;
    }


}
