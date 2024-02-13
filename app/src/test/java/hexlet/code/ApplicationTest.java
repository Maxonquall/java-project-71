package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ApplicationTest {
    @Test
        void nestedParseTest() throws Exception {
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                +  "}";
        String actual = Differ.generate("file1.yml", "file2.yml");
        assertEquals(expected, actual);

    }

}



/*   @Test
        void differTestRude() throws Exception {
        var actual1 = Differ.generate("filepath1.yml", "filepath2.yml");
        String expected1 = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n  - timeout: 50\n"
               + "  + timeout: 20\n  + verbose: true\n}";
        assertEquals(expected1, actual1);
//  var file1 = "\"host\": \"hexlet.io\",\n\"timeout\": 50,\n\"proxy\": \"192.168.3.11\",\n\"follow\": false";
//     var file2 = "\"timeout\": 20,\n\"verbose\": true,\n\"host\": \"hexlet.io\"";

    }

    @Test
        void differTestDelete() throws Exception {
        var file1 = Files.readString(Paths.get("filepath1.yml").toAbsolutePath().normalize());
        var file2 = Files.readString(Paths.get("filepath2.yml").toAbsolutePath().normalize());
        var actual2 = Differ.generate("filepath1.yml", "filepath2.yml");
        assertTrue(actual2.contains("  - proxy: 123.234.53.22"));

    }

    @Test
    void differTestEqual() throws Exception {
        var file1 = Files.readString(Paths.get("filepath1.yml").toAbsolutePath().normalize());
        var file2 = Files.readString(Paths.get("filepath2.yml").toAbsolutePath().normalize());
        var actual3 = Differ.generate("filepath1.yml", "filepath2.yml");
        assertTrue(actual3.contains("    host: hexlet.io"));
    }

    @Test
    void differTestDifference() throws Exception {
        var file1 = Files.readString(Paths.get("filepath1.yml").toAbsolutePath().normalize());
        var file2 = Files.readString(Paths.get("filepath2.yml").toAbsolutePath().normalize());
        var actual4 = Differ.generate("filepath1.yml", "filepath2.yml");
        assertTrue(actual4.contains("  - timeout: 50\n  + timeout: 20"));
    }*/

