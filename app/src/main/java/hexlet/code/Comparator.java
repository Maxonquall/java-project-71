package hexlet.code;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        var result = new LinkedList<Map<String, Object>>();
        preprocess(map1);
        preprocess(map2);
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            var valueMap = new HashMap<String, Object>();
            valueMap.put("masterKey", key);
            if (!map1.containsKey(key)) {
                valueMap.put(key, map2.get(key));
                valueMap.put("diffValue", "added");
                valueMap.put("newValue", map2.get(key));
            } else if (!map2.containsKey(key)) {
                valueMap.put(key, map1.get(key));
                valueMap.put("diffValue", "deleted");
                valueMap.put("oldValue", map1.get(key));
            } else if (map1.get(key).equals(map2.get(key))) {
                valueMap.put(key, map1.get(key));
                valueMap.put("diffValue", "unchanged");
                valueMap.put("oldValue", map1.get(key));
                valueMap.put("newValue", map2.get(key));
            } else {
                valueMap.put(key, map2.get(key));
                valueMap.put("diffValue", "changed");
                valueMap.put("oldValue", map1.get(key));
                valueMap.put("newValue", map2.get(key));
            }
            postProcess(valueMap);
            result.add(valueMap);
        }

        return result;

    }

    private static Map<String, Object> preprocess(Map<String, Object> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("null");
            }
        }
        return map;
    }
    private static Map<String, Object> postProcess(Map<String, Object> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue() == "null") {
                entry.setValue(null);
            }
        }
        return map;
    }
}
