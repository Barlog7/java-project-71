package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import java.util.LinkedHashMap;
import java.util.Map;

//import static hexlet.code.formatters.Stylish.formatKeyStatus;

public class Json {
    public static String render(Map<String, String> map) throws JsonProcessingException {
        String text = "";
        ObjectMapper mapper = new ObjectMapper();
        //var mapChange = new LinkedHashMap<String, Object>();

//        var entries = map.entrySet();
//        for (var entry : entries) {
//            mapChange.put(formatKeyStatus(entry.getKey()), entry.getValue());
//        }


        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        text = mapper.writeValueAsString(map);
        //text = mapper.writeValueAsString(map);

        return text;
    }

}
