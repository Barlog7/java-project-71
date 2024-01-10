package hexlet.code.formatters;

import java.util.Map;

public class Stylish {

    public static String render(Map<String, String> map) {
        StringBuilder text = new StringBuilder();
        text.append("{" + "\n");
        //text.insert(0, "{" + "\n");

        var entries = map.entrySet();
        for (var entry : entries) {
            text.append(entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n");
        }

        text.append("}");
        return text.toString();
    }

    /*public static String formatedTextStylish(String key, Object value, String type) {
        String sFormat = "";
        String typeSign = "";
        switch (type) {
            case ("add") :
                typeSign = "+";
                break;
            case ("remove") :
                typeSign = "-";
                break;
            default:
                typeSign = " ";
        }
        sFormat = "  " + typeSign + " " + key + ": " + String.valueOf(value) + "\n";
        return sFormat;
    }
    public static String formatedTextStylish(String key, Object value1, Object value2) {
        String sFormat = "";
        sFormat = "  " + "-" + " " + key + ": " + String.valueOf(value1) + "\n"
                + "  " + "+" + " " + key + ": " + String.valueOf(value2) + "\n";
        return sFormat;
    }
    public static StringBuilder bulidStartEndSign(StringBuilder text) {
        text.insert(0, "{" + "\n");
        text.append("}");
        return text;
    }*/
}
