package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

//import static hexlet.code.formatters.Plain.deteleEndRow;
//import static hexlet.code.formatters.Plain.formatedTextSPlain;
//import static hexlet.code.formatters.Stylish.bulidStartEndSign;
//import static hexlet.code.formatters.Stylish.formatedTextStylish;

public class Formater {

    public static String render(Map<String, String> mapDiff, String format) throws JsonProcessingException {
        String result = "";
        switch (format) {
            case "stylish" :
                result = Stylish.render(mapDiff);
                break;
            case "plain" :
                result = Plain.render(mapDiff);
                break;
            case "json" :
                result = Json.render(mapDiff);
                break;
            default:
                break;
        }
        return result;
    }
    /*public static String formatedText(String key, Object value, String type, String typeFormat) {
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
            case ("plain") :
                returnText = formatedTextSPlain(key, value1, value2);
                break;
            default:
                returnText = formatedTextStylish(key, value1, value2);
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
    }*/

}
