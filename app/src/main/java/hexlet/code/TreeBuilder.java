package hexlet.code;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;

public class TreeBuilder {
    public static List<Map<String, Object>> build(Map<String, Object> map1, Map<String, Object> map2) {
        var result = new LinkedList<Map<String, Object>>();
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
            } else if (isEqual(map1.get(key), map2.get(key))) {
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
            result.add(valueMap);
        }

        return result;

    }

    private static boolean isEqual(Object getValue1, Object getValue2) {
        Object value1 = getValue1 == null ? "null" : getValue1;
        Object value2 = getValue2 == null ? "null" : getValue2;
        return value1.equals(value2);
    }
}
