package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;
import java.util.LinkedList;


public class Parser {



    public static String parse(String file1, String file2, String dataFormat, String style)
            throws JsonProcessingException {
        var diff = "";
        var diffList = new LinkedList<Map<String, Object>>();
        switch (dataFormat) {
            case "yml" -> {
                ObjectMapper mapper = new YAMLMapper();
                var map1 = mapper.readValue(file1, new TypeReference<Map<String, Object>>() { });
                var map2 = mapper.readValue(file2, new TypeReference<Map<String, Object>>() { });
                diffList = (LinkedList<Map<String, Object>>) Comparator.compare(map1, map2);
                diff = Formatter.format(diffList, style);
            }
            case "json" -> {
                ObjectMapper objectMapper = new ObjectMapper();
                var map1 = objectMapper.readValue(file1, new TypeReference<Map<String, Object>>() { });
                var map2 = objectMapper.readValue(file2, new TypeReference<Map<String, Object>>() { });
                diffList = (LinkedList<Map<String, Object>>) Comparator.compare(map1, map2);
                diff = Formatter.format(diffList, style);
            }
            default -> throw new IllegalArgumentException("Wrong format");
        }
        return diff;

    }

}
