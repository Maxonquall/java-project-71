package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import hexlet.code.Differ;
import org.junit.jupiter.api.*;*/

class ApplicationTest {
    @Test
        void differTest() throws Exception {
        var file1 = "\"host\": \"hexlet.io\",\n\"timeout\": 50,\n\"proxy\": \"192.168.3.11\",\n\"follow\": false";
        var file2 = "\"timeout\": 20,\n\"verbose\": true,\n\"host\": \"hexlet.io\"";
        var actual = Differ.generate("file1.json", "file2.json");

        String expected = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n  - timeout: 50\n"
               + "  + timeout: 20\n  + verbose: true\n}";
        assertEquals(expected, actual);


    }
}
