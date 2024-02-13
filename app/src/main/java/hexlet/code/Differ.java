package hexlet.code;


import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filepath1, String filepath2, String style) throws Exception {

        var file1 = Paths.get(filepath1).toAbsolutePath().normalize();
        var file2 = Paths.get(filepath2).toAbsolutePath().normalize();
        var file1Str = Files.readString(file1);
        var file2Str = Files.readString(file2);
        ObjectMapper objectMapper = new ObjectMapper();
        var map1 = objectMapper.readValue(file1Str, new TypeReference<Map<String, Object>>() { });
        var map2 = objectMapper.readValue(file2Str, new TypeReference<Map<String, Object>>() { });
        var parsedList = Parser.compare(map1, map2, style);
        return parsedList;

    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        String style = "stylish";
        return generate(filepath1, filepath2, style);
    }

}
