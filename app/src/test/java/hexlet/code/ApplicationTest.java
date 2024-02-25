package hexlet.code;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ApplicationTest {

   /* private static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName).toAbsolutePath().normalize()));
    }*/
   private static String readFile(String fileName) throws IOException {
       return Files.readString(Paths.get(fileName).toAbsolutePath().normalize()).trim();
   }

    @Test
    void jsonDefaultTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish.txt").strip();
        String actual = Differ.generate("filepath1.json", "filepath2.json").strip();
        assertEquals(expected, actual);
    }
    @Test
    void ymlDefaultTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish.txt");
        String actual = Differ.generate("filepath1.yml", "filepath2.yml");
        assertEquals(expected, actual);
    }
    @Test
        void jsonStylishTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish.txt");
        String actual = Differ.generate("filepath1.json", "filepath2.json", "stylish");
        assertEquals(expected, actual);
    }
    @Test
    void ymlStylishTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish.txt");
        String actual = Differ.generate("filepath1.yml", "filepath2.yml", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void jsonPlainTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Plain");
        String actual = Differ.generate("filepath1.json", "filepath2.json", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void ymlPlainTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Plain");
        String actual = Differ.generate("filepath1.yml", "filepath2.yml", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void jsonJsonTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/JSON");
        String actual = Differ.generate("filepath1.json", "filepath2.json", "json");
        assertEquals(expected, actual);
    }

    @Test
    void ymlJsonTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/JSON");
        String actual = Differ.generate("filepath1.yml", "filepath2.yml", "json");
        assertEquals(expected, actual);
    }





   /* @Test
        void nestedParseTest() throws Exception {
        String expected = """
                {
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
                }""";
        String actual = Differ.generate("filepath1.json", "filepath2.json");
        assertEquals(expected, actual);

    }
    void nestedParseTestYml() throws Exception {
        String expected = """
                {
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
                }""";
        String actual = Differ.generate("filepath1.yml", "filepath2.yml");
        assertEquals(expected, actual);

    }
    
    @Test
    void plainTest() throws Exception {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        String actual = Differ.generate("filepath1.json", "filepath2.json", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void jsonTest() throws Exception {
        String expected = "[{\"key\":\"chars1\",\"status\":\"unchanged\",\"value\":[\"a\",\"b\",\"c\"]},"
                + "{\"key\":\"chars2\",\"status\":\"changed\",\"old_value\":[\"d\",\"e\",\"f\"],\"new_value\":false},"
                + "{\"key\":\"checked\",\"status\":\"changed\",\"old_value\":false,\"new_value\":true},"
                + "{\"key\":\"default\",\"status\":\"changed\",\"old_value\":null,\"new_value\":"
                + "[\"value1\",\"value2\"]},"
                + "{\"key\":\"id\",\"status\":\"changed\",\"old_value\":45,\"new_value\":null},"
                + "{\"key\":\"key1\",\"status\":\"deleted\",\"value\":\"value1\"},"
                + "{\"key\":\"key2\",\"status\":\"added\",\"value\":\"value2\"},"
                + "{\"key\":\"numbers1\",\"status\":\"unchanged\",\"value\":[1,2,3,4]},"
                + "{\"key\":\"numbers2\",\"status\":\"changed\",\"old_value\":[2,3,4,5],\"new_value\":[22,33,44,55]},"
                + "{\"key\":\"numbers3\",\"status\":\"deleted\",\"value\":[3,4,5]},"
                + "{\"key\":\"numbers4\",\"status\":\"added\",\"value\":[4,5,6]},"
                + "{\"key\":\"obj1\",\"status\":\"added\",\"value\":{\"nestedKey\":\"value\",\"isNested\":true}},"
                + "{\"key\":\"setting1\",\"status\":\"changed\",\"old_value\":\"Some value\",\"new_value\":"
                + "\"Another value\"},"
                + "{\"key\":\"setting2\",\"status\":\"changed\",\"old_value\":200,\"new_value\":300},"
                + "{\"key\":\"setting3\",\"status\":\"changed\",\"old_value\":true,\"new_value\":\"none\"}]";
        String actual = Differ.generate("filepath1.json", "filepath2.json", "json");
        assertEquals(expected, actual);
    }
    @Test
    void jsonTestYml() throws Exception {
        String expected = "[{\"key\":\"chars1\",\"status\":\"unchanged\",\"value\":[\"a\",\"b\",\"c\"]},"
                + "{\"key\":\"chars2\",\"status\":\"changed\",\"old_value\":[\"d\",\"e\",\"f\"],\"new_value\":false},"
                + "{\"key\":\"checked\",\"status\":\"changed\",\"old_value\":false,\"new_value\":true},"
                + "{\"key\":\"default\",\"status\":\"changed\",\"old_value\":null,\"new_value\":"
                + "[\"value1\",\"value2\"]},"
                + "{\"key\":\"id\",\"status\":\"changed\",\"old_value\":45,\"new_value\":null},"
                + "{\"key\":\"key1\",\"status\":\"deleted\",\"value\":\"value1\"},"
                + "{\"key\":\"key2\",\"status\":\"added\",\"value\":\"value2\"},"
                + "{\"key\":\"numbers1\",\"status\":\"unchanged\",\"value\":[1,2,3,4]},"
                + "{\"key\":\"numbers2\",\"status\":\"changed\",\"old_value\":[2,3,4,5],\"new_value\":[22,33,44,55]},"
                + "{\"key\":\"numbers3\",\"status\":\"deleted\",\"value\":[3,4,5]},"
                + "{\"key\":\"numbers4\",\"status\":\"added\",\"value\":[4,5,6]},"
                + "{\"key\":\"obj1\",\"status\":\"added\",\"value\":{\"nestedKey\":\"value\",\"isNested\":true}},"
                + "{\"key\":\"setting1\",\"status\":\"changed\",\"old_value\":\"Some value\",\"new_value\":"
                + "\"Another value\"},"
                + "{\"key\":\"setting2\",\"status\":\"changed\",\"old_value\":200,\"new_value\":300},"
                + "{\"key\":\"setting3\",\"status\":\"changed\",\"old_value\":true,\"new_value\":\"none\"}]";
        String actual = Differ.generate("filepath1.yml", "filepath2.yml", "json");
        assertEquals(expected, actual);
    }*/
}
