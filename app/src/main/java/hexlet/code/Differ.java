package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Map;

import static hexlet.code.Utils.mapToString;

public class Differ {
    public static String generate(String filePath1, String filePath2) {

        ObjectMapper mapper = new ObjectMapper();
        Map mapFirstFile = new LinkedHashMap<String, String>();
        Map mapSecondFile = new LinkedHashMap<String, String>();

        try {
            mapFirstFile = getData(filePath1, mapper);
            mapSecondFile = getData(filePath2, mapper);
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        Map result = createResult(mapFirstFile, mapSecondFile);
        //String returnString = result.entrySet().stream().flatMap(y -> y).collect(Collectors.joining(" "));
        //String returnString = StringUtils.join(result);
        String returnString = mapToString(result);
        System.out.println(returnString);
        return  returnString;
    }
    public static Map getData(String filePath, ObjectMapper mapper) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        Map<String, String> mapJson = mapper.readValue(new File(filePath), Map.class);

        System.out.println(mapJson);
        return mapJson;
    }
    public static Map createResult(Map map1, Map map2) {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();
        System.out.println(itemsSorted);
        for (var key : itemsSorted) {
            System.out.println(key);
            if (!map1.containsKey(key)) {
                var value2 = map2.get(key);
                mapResult.put("  + " + key, value2);
                continue;
            } else if (!map2.containsKey(key)) {
                var value1 = map1.get(key);
                mapResult.put("  - " + key, value1);
                continue;
            }
            var value1 = map1.get(key);
            var value2 = map2.get(key);
            if (value1.equals(value2)) {
                mapResult.put("    " + key, value1);
            } else {
                mapResult.put("  - " + key, value1);
                mapResult.put("  + " + key, value2);
            }
        }

        return mapResult;
    }

}
