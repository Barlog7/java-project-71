package hexlet.code;

public class Formater {
    public static String formatedText(String key, Object value, String type, String typeFormat) {
        String sFormat = "";
        if (typeFormat.equals("stylish")) {
            sFormat = "  " + type + " " + key + ": " + String.valueOf(value) + "\n";
        }
        return sFormat;
    }
}
