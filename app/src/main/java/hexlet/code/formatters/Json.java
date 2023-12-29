package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.Map;

import static hexlet.code.formatters.Plain.deteleEndRow;
import static hexlet.code.formatters.Stylish.bulidStartEndSign;

public class Json {
    public static String formatToJson(Map<String, String> map) {
        String text = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            text = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return text;
    }
}
