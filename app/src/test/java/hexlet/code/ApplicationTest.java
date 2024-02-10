package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest {

    @Test
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
    }

}

