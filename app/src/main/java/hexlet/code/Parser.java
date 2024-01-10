package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map getData(String sData, String type) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        if (type.equals("yml")) {
            mapper = new YAMLMapper();
        }

        Map<String, String> mapJson = mapper.readValue(sData, Map.class);



        return mapJson;
    }


    public static Object checkNull(Object value) {
        if (value == null) {
            value = "null";
        }
        return value;
    }
}
