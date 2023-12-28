package hexlet.code;

import static hexlet.code.formatters.Plain.deteleEndRow;
import static hexlet.code.formatters.Plain.formatedTextSPlain;
import static hexlet.code.formatters.Stylish.bulidStartEndSign;
import static hexlet.code.formatters.Stylish.formatedTextStylish;

public class Formater {
    public static String formatedText(String key, Object value, String type, String typeFormat) {
        String returnText = "";
        switch (typeFormat) {
            case ("stylish") :
                returnText = formatedTextStylish(key, value, type);
                break;
            default:
                returnText = formatedTextSPlain(key, value, type);
        }
        return returnText;
    }
    public static String formatedText(String key, Object value1, Object value2, String typeFormat) {
        String returnText = "";
        switch (typeFormat) {
            case ("stylish") :
                returnText = formatedTextStylish(key, value1, value2);
                break;
            default:
                returnText = formatedTextSPlain(key, value1, value2);
        }
        return returnText;
    }
    public static StringBuilder addStartEndSign(StringBuilder text, String format) {
        if (format.equals("stylish")) {
            text = bulidStartEndSign(text);
        } else {
            text = deteleEndRow(text);
        }
        return text;
    }
}
