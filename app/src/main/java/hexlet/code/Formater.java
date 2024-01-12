package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

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


}
