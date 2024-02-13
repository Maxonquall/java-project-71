package hexlet.code;

import java.util.List;

public class Stylish {
    public static String format(List<String> parsedList) {
        StringBuilder resultToString = new StringBuilder("{\n");
        for (String s : parsedList) {
            resultToString.append(s).append("\n");
        }
        resultToString.append("}");

        return resultToString.toString();

    }
}
