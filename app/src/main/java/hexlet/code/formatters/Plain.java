package hexlet.code.formatters;

import java.util.Map;

import static hexlet.code.DiffBuilder.ADD;
import static hexlet.code.DiffBuilder.DELETE;
import static hexlet.code.DiffBuilder.CHANGE_FROM;
import static hexlet.code.DiffBuilder.CHANGE_TO;


public class Plain {

    public static String render(Map<String, String> map) {
        StringBuilder text = new StringBuilder();
        final int pozition = 4;
        var entries = map.entrySet();
        for (var entry : entries) {
            //text.append( entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n");
            int index = entry.getKey().indexOf("#");
            String formatTextRow = "";
            String keyStatus = entry.getKey().substring(0, index + 1);
            String keyText = entry.getKey().substring(index + 1);

            switch (keyStatus) {
                case (ADD) :
                    formatTextRow = "Property '"
                            + keyText
                            + "' was added with value: "
                            + formatingValue(entry.getValue())
                            + "\n";
                    break;
                case (DELETE) :
                    formatTextRow = "Property '" + keyText + "' was removed" + "\n";
                    break;
                case (CHANGE_TO) :

                    formatTextRow = "Property '"
                            + keyText
                            + "' was updated. From "
                            + formatingValue(map.get(CHANGE_FROM + keyText))
                            + " to " + formatingValue(entry.getValue()) + "\n";
                    break;
                default :
                    break;
            }
            text.append(formatTextRow);
        }

        text = deteleEndRow(text);
        return text.toString();
    }


    public static String formatedTextSPlain(String key, Object value1, Object value2) {
        String sFormat = "";
        sFormat = "Property '"
                    + key
                    + "' was updated. From "
                    + formatingValue(value1)
                    + " to " + formatingValue(value2) + "\n";
        return sFormat;
    }
    public static String formatingValue(Object value) {
        String returnValue = "";

        if (value.equals("null")) {
            returnValue = String.valueOf(value);
        } else if (value instanceof String) {
            returnValue = "'" + String.valueOf(value) + "'";
        } else if (value instanceof Integer || value instanceof Boolean) {
            returnValue = String.valueOf(value);
        } else {
            returnValue = "[complex value]";
        }
        return returnValue;
    }
    public static StringBuilder deteleEndRow(StringBuilder text) {
        if (text.length() > 0) {
            text = text.deleteCharAt(text.length() - 1);
        }
        return text;
    }
}
