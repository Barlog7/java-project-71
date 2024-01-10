package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class Json {
    public static String render(Map<String, String> map) throws JsonProcessingException {
        String text = "";
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        text = mapper.writeValueAsString(map);

        return text;
    }


    /*public static String formatToJson(Map<String, String> map) throws JsonProcessingException {
        String text = "";
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        text = mapper.writeValueAsString(map);

        return text;
    }*/
}
