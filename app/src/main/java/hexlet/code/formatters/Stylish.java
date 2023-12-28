package hexlet.code.formatters;

public class Stylish {
    public static String formatedTextStylish(String key, Object value, String type) {
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
    }
}
