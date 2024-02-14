package hexlet.code;


import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Parser {
    public static String compare(Map<String, Object> map1Raw, Map<String, Object> map2Raw, String style) {
        var result = new ArrayList<String>();
        var map1 = removeNull(map1Raw);
        var map2 = removeNull(map2Raw);
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.add("    " + key + ": " + map1.get(key));
                } else {
                    result.add("  - " + key + ": " + map1.get(key));
                    result.add("  + " + key + ": " + map2.get(key));
                }
            } else if (map1.containsKey(key)) {
                result.add("  - " + key + ": " + map1.get(key));
            } else {
                result.add("  + " + key + ": " + map2.get(key));
            }

        }
                return Formatter.format(result, style);
    }

    public static String compare(Map<String, Object> map1Raw, Map<String, Object> map2Raw) {
        String style = "stylish";
        return  compare(map1Raw, map2Raw, style);
    }

    private static Map<String, Object> removeNull(Map<String, Object> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("null");
            }
        }
        return map;
    }


}
