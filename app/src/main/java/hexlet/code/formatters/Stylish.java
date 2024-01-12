package hexlet.code.formatters;

import java.util.Map;

//import static hexlet.code.DiffBuilder.*;
import static hexlet.code.DiffBuilder.ADD;
import static hexlet.code.DiffBuilder.DELETE;
import static hexlet.code.DiffBuilder.CHANGE_TO;
import static hexlet.code.DiffBuilder.CHANGE_FROM;
import static hexlet.code.DiffBuilder.NOT_CHANGE;

public class Stylish {

    static final int MOVE = 1;
    public static String render(Map<String, String> map) {
        StringBuilder text = new StringBuilder();
        text.append("{" + "\n");

        var entries = map.entrySet();
        for (var entry : entries) {
            text.append(formatKeyStatus(entry.getKey()) + ": " + String.valueOf(entry.getValue()) + "\n");
        }

        text.append("}");
        return text.toString();
    }

    public static String formatKeyStatus(String key) {
        int index = key.indexOf("#");
        String returnText = "";
        String keyOperation = key.substring(0, index + MOVE);
        switch (keyOperation) {
            case (ADD) :
                returnText = "  + ";
                break;
            case (DELETE) :
                returnText = "  - ";
                break;
            case (NOT_CHANGE) :
                returnText = "    ";
                break;
            case (CHANGE_FROM) :
                returnText = "  - ";
                break;
            case (CHANGE_TO) :
                returnText = "  + ";
            default:
        }
        return returnText + key.substring(index + MOVE);
    }

}
