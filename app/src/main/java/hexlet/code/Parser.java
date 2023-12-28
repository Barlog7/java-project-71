package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static hexlet.code.Formater.formatedText;

public class Parser {
    public static Map getData(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String typeFile = "";
        if (path.getFileName().toString().contains(".yml")) {
            typeFile = "yml";
            //System.out.println(typeFile + filePath);
            mapper = new YAMLMapper();


        } else if (path.getFileName().toString().contains(".json")) {
            typeFile = "json";
            //System.out.println(typeFile + filePath);
        } else {
            throw new Exception("File '" + path + "' not .yml or .json type");
        }
        //System.out.println(typeFile + filePath);
        Map<String, String> mapJson = mapper.readValue(new File(String.valueOf(path)), Map.class);


        //System.out.println(mapJson);
        return mapJson;
    }
   /* public static Map createResult(Map map1, Map map2) {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();
        //System.out.println(itemsSorted);
        for (var key : itemsSorted) {
            //System.out.println(key);
            var value1 = map1.get(key);
            if (value1 ==  null) {
                value1 = "null";
            }
            var value2 = map2.get(key);
            if (value2 ==  null) {
                value2 = "null";
            }
            if (!map1.containsKey(key)) {
                //var value2 = map2.get(key);
                mapResult.put("  + " + key, value2);
                continue;
            } else if (!map2.containsKey(key)) {
                //var value1 = map1.get(key);
                mapResult.put("  - " + key, value1);
                continue;
            }
            //var value1 = map1.get(key);
            //var value2 = map2.get(key);
            if (value1.equals(value2)) {
                mapResult.put("    " + key, value1);
            } else {
                mapResult.put("  - " + key, value1);
                mapResult.put("  + " + key, value2);
            }
        }

        return mapResult;
    }*/
    public static String createResult(Map map1, Map map2, String typeFormat) {
        //Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();
        //System.out.println(itemsSorted);
        StringBuilder stringReturn = new StringBuilder("{" + "\n");
        for (var key : itemsSorted) {
            //System.out.println(key);
            var value1 = checkNull(map1.get(key));
            var value2 = checkNull(map2.get(key));
            String formatText = "";
            if (!map1.containsKey(key)) {
                //var value2 = map2.get(key);
                formatText = formatedText(key, value2, "+", typeFormat);
                stringReturn.append(formatText);
                //mapResult.put("  + " + key, value2);

                continue;
            } else if (!map2.containsKey(key)) {
                //var value1 = map1.get(key);
                formatText = formatedText(key, value1, "-", typeFormat);
                stringReturn.append(formatText);
                //mapResult.put("  - " + key, value1);
                continue;
            }
            //var value1 = map1.get(key);
            //var value2 = map2.get(key);
            if (value1.equals(value2)) {
                //mapResult.put("    " + key, value1);
                formatText = formatedText(key, value1, " ", typeFormat);
                stringReturn.append(formatText);
            } else {
                formatText = formatedText(key, value1, "-", typeFormat);
                stringReturn.append(formatText);
                formatText = formatedText(key, value2, "+", typeFormat);
                stringReturn.append(formatText);
                //mapResult.put("  - " + key, value1);
                //mapResult.put("  + " + key, value2);
            }
        }

        //return mapResult;
        stringReturn.append("}");
        return stringReturn.toString();
    }

    public static Object checkNull(Object value) {
        if (value == null) {
            value ="null";
        }
        return value;
    }
}
