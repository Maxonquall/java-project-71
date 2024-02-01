package hexlet.code;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static  String generate(String filepath1, String filepath2) throws Exception {

      //  String filepath1 = "file1.json";
      //  String filepath2 = "file2.json";
        var file1 = Paths.get(filepath1).toAbsolutePath().normalize().toString();
        var file2 = Paths.get(filepath2).toAbsolutePath().normalize().toString();

        var map1 = Arrays.stream(file1.split(",\n"))
                .map(str -> str.split(": "))
                .collect(Collectors.toMap(
                        str -> str[0].replaceAll("\"", ""),
                        str -> {
                            if (str[1].equals("true") || str[1].equals("false")) {
                                return Boolean.parseBoolean(str[1]);
                            } else if (str[1].startsWith("\"")) {
                                return str[1].replaceAll("\"", "");
                            } else {
                                return Integer.parseInt(str[1]);
                            }
                        }
                ));

        var map2 = Arrays.stream(file2.split(",\n"))
                .map(str -> str.split(": "))
                .collect(Collectors.toMap(
                        str -> str[0].replaceAll("\"", ""),
                        str -> {
                            if (str[1].equals("true") || str[1].equals("false")) {
                                return Boolean.parseBoolean(str[1]);
                            } else if (str[1].startsWith("\"")) {
                                return str[1].replaceAll("\"", "");
                            } else {
                                return Integer.parseInt(str[1]);
                            }
                        }
                ));

        var result = new ArrayList<String>();

        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.add(key + ": " + map1.get(key));
                } else {
                    result.add("-" + key + ": " + map1.get(key));
                    result.add("+" + key + ": " + map2.get(key));
                }
            } else if (map1.containsKey(key)) {
                result.add("-" + key + ": " + map1.get(key));
            } else {
                result.add("+ " + key + ": " + map2.get(key));
            }
        }
        var resutToString = "";
        for (var i = 0; i < result.size() - 1; i++) {
            resutToString += result.get(i) + "\n";
        }
        resutToString += result.get(result.size() - 1);

        return resutToString;

    }
}
