package hexlet.code.formatters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Plain {
    public static String make(List<String> parsedList) {
        var diff = makeMap(parsedList);



    }

    private static Map<String,String> makeMap(List<String> list) {
        var map = new HashMap<String,String>();
        for (var s : list) {
            s = s.replace("  - ", "");
            s = s.replace("  + ", "");
            map.put(s.split(":")[0], s.split(":")[1]);
        }
        return map;
    }


}
// resultToString.append(s).append("\n");
/*{
          chars1: [a, b, c]
        - chars2: [d, e, f]
        + chars2: false
        - checked: false
        + checked: true
        - default: null
        + default: [value1, value2]
        - id: 45
        + id: null
        - key1: value1
        + key2: value2
          numbers1: [1, 2, 3, 4]
        - numbers2: [2, 3, 4, 5]
        + numbers2: [22, 33, 44, 55]
        - numbers3: [3, 4, 5]
        + numbers4: [4, 5, 6]
        + obj1: {nestedKey=value, isNested=true}
        - setting1: Some value
        + setting1: Another value
        - setting2: 200
        + setting2: 300
        - setting3: true
        + setting3: none
}*/

/*  StringBuilder resultToString = new StringBuilder();
        for (String s : parsedList) {

            if (s.startsWith("  - ")) {
                if (s.contains("[") || s.contains("{")) {
                    resultToString.append(replaceBracket(s));
                }
                s = s.replace("  - ", "");
                resultToString.append("Property '" + s.split(":")[0] + " was updated. From "
                + s.split(":")[1] + " to ");
            }

            if (s.startsWith("  + ")) {
                if (s.contains("[") || s.contains("{")) {
                    resultToString.append(replaceBracket(s));
                }
                s = s.replace("  + ", "");
                resultToString.append(s.split(":")[1]);
            }

        }
        return resultToString.toString();*/

 /* private static String replaceBracket(String s) {
        if (s.contains("[")) {
            var substring = s.split("\\[");
            substring[1] = "[complex value]";
            s = substring[0] + substring[1];
        }
        if (s.contains("{")) {
            var substring = s.split("\\{");
            substring[1] = "[complex value]";
            s = substring[0] + substring[1];
        }
        return s;
    }*/