package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Parser {
    public static List<String> compare(Map<String, Object> map1, Map<String, Object> map2) {
        var result = new ArrayList<String>();

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
        return result;
    }
}
