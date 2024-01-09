package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
//import org.apache.commons.collections4.CollectionUtils;

//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
import java.util.Map;

//import static hexlet.code.Formater.addStartEndSign;
//import static hexlet.code.Formater.formatedText;
//import static hexlet.code.formatters.Json.formatToJson;

public class Parser {
    public static Map getData(String sData, String type) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        if (type.equals("yml")) {
            mapper = new YAMLMapper();
        }
        //Path path = Paths.get(filePath).toAbsolutePath().normalize();
       /* if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String typeFile = "";
        if (path.getFileName().toString().contains(".yml")) {
            typeFile = "yml";

            mapper = new YAMLMapper();


        } else if (path.getFileName().toString().contains(".json")) {
            typeFile = "json";

        } else {
            throw new Exception("File '" + path + "' not .yml or .json type");
        }*/

        Map<String, String> mapJson = mapper.readValue(sData, Map.class);



        return mapJson;
    }

   /* public static String createResult(Map map1, Map map2, String typeFormat) {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();

        StringBuilder stringReturn = new StringBuilder();

        for (var key : itemsSorted) {
            //System.out.println(key);
            var value1 = checkNull(map1.get(key));
            var value2 = checkNull(map2.get(key));
            String formatText = "";
            if (!map1.containsKey(key)) {
                //var value2 = map2.get(key);
                formatText = formatedText(key, value2, "add", typeFormat);
                stringReturn.append(formatText);
                mapResult.put("  + " + key, value2);

                continue;
            } else if (!map2.containsKey(key)) {
                //var value1 = map1.get(key);
                formatText = formatedText(key, value1, "remove", typeFormat);
                stringReturn.append(formatText);
                mapResult.put("  - " + key, value1);
                continue;
            }

            if (value1.equals(value2)) {
                mapResult.put("    " + key, value1);
                formatText = formatedText(key, value1, "not change", typeFormat);
                stringReturn.append(formatText);
            } else {
                formatText = formatedText(key, value1, value2, typeFormat);
                stringReturn.append(formatText);

                mapResult.put("  - " + key, value1);
                mapResult.put("  + " + key, value2);
            }
        }


        if (typeFormat.equals("json")) {
            return formatToJson(mapResult);
        }
        stringReturn = addStartEndSign(stringReturn, typeFormat);
        return stringReturn.toString();
    }*/

    public static Object checkNull(Object value) {
        if (value == null) {
            value = "null";
        }
        return value;
    }
}
