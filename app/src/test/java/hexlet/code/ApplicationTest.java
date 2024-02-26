package hexlet.code;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ApplicationTest {

    private static String readFile(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName).toAbsolutePath().normalize()).trim();
    }

    @Test
    void jsonDefaultTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish");
        String actual = Differ.generate("file1.json", "file2.json");
        assertEquals(expected, actual);
    }
    @Test
    void ymlDefaultTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish");
        String actual = Differ.generate("file1.yml", "file2.yml");
        assertEquals(expected, actual);
    }
    @Test
        void jsonStylishTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish");
        String actual = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(expected, actual);
    }
    @Test
    void ymlStylishTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Stylish");
        String actual = Differ.generate("file1.yml", "file2.yml", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void jsonPlainTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Plain");
        String actual = Differ.generate("file1.json", "file2.json", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void ymlPlainTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/Plain");
        String actual = Differ.generate("file1.yml", "file2.yml", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void jsonJsonTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/JSON");
        String actual = Differ.generate("file1.json", "file2.json", "json");
        assertEquals(expected, actual);
    }

    @Test
    void ymlJsonTest() throws Exception  {
        String expected = readFile("src/test/resources/fixtures/JSON");
        String actual = Differ.generate("file1.yml", "file2.yml", "json");
        assertEquals(expected, actual);
    }

}
