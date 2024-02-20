package hexlet.code;


import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Differ {
    public static String generate(String filepath1, String filepath2, String style) throws Exception {
        var diff = "";
        var file1 = Paths.get(filepath1).toAbsolutePath().normalize();
        var file2 = Paths.get(filepath2).toAbsolutePath().normalize();
        var file1Str = Files.readString(file1);
        var file2Str = Files.readString(file2);
        //var dataFormat = file1Str.split(".")[1];
        int index = filepath1.lastIndexOf('.');
        var dataFormat = index > 0
                ? filepath1.substring(index + 1)
                : "";

        switch (dataFormat) {
            case "yml" -> {
                ObjectMapper mapper = new YAMLMapper();
                var map1 = mapper.readValue(file1Str, new TypeReference<Map<String, Object>>() { });
                var map2 = mapper.readValue(file2Str, new TypeReference<Map<String, Object>>() { });
                diff = Parser.compare(map1, map2, style);
            }
            case "json " -> {
                ObjectMapper objectMapper = new ObjectMapper();
                var map1 = objectMapper.readValue(file1Str, new TypeReference<Map<String, Object>>() { });
                var map2 = objectMapper.readValue(file2Str, new TypeReference<Map<String, Object>>() { });
                diff = Parser.compare(map1, map2, style);
            }
            default -> throw new IllegalArgumentException("Wrong format");
        }

        return diff;

    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

}
