package hexlet.code;

import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static  String generate(String filepath1, String filepath2) throws Exception {

        var file1 = Paths.get(filepath1).toAbsolutePath().normalize();
        var file2 = Paths.get(filepath2).toAbsolutePath().normalize();
        var file1Str = Files.readString(file1);
        var file2Str = Files.readString(file2);
        ObjectMapper objectMapper = new ObjectMapper();
        var map1 = objectMapper.readValue(file1Str, new TypeReference<Map<String,Object>>(){});
        var map2 = objectMapper.readValue(file2Str, new TypeReference<Map<String,Object>>(){});

        var result = new ArrayList<String>();

        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.add("  " + key + ": " + map1.get(key));
                } else {
                    result.add("- " + key + ": " + map1.get(key));
                    result.add("+ " + key + ": " + map2.get(key));
                }
            } else if (map1.containsKey(key)) {
                result.add("- " + key + ": " + map1.get(key));
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
