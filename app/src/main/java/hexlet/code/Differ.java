package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filepath1, String filepath2, String style) throws Exception {
        var file1 = Paths.get(filepath1).toAbsolutePath().normalize();
        var file2 = Paths.get(filepath2).toAbsolutePath().normalize();
        var file1Str = Files.readString(file1);
        var file2Str = Files.readString(file2);
        int index = filepath1.lastIndexOf('.');
        var dataFormat = index > 0
                ? filepath1.substring(index + 1)
                : "";
        return Parser.parse(file1Str, file2Str, dataFormat, style);


    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

}
