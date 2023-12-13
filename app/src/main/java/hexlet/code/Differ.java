package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Differ {
    //ObjectMapper mapper;
    public static void generate(String filePath1, String filePath2) {
        System.out.println(filePath1);
        System.out.println(filePath2);
        ObjectMapper mapper = new ObjectMapper();
        Map mapFirstFile = new LinkedHashMap<String, String>();
        Map mapSecondFile = new LinkedHashMap<String, String>();
        Map result = new LinkedHashMap<String, String>();
        try {
            mapFirstFile = getData(filePath1, mapper);
            mapSecondFile = getData(filePath2, mapper);
        } catch (RuntimeException e) {
            System.out.println(e);
            //throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        result = createResult(mapFirstFile, mapSecondFile);
        System.out.println(result);
    }
    public static Map getData(String filePath, ObjectMapper mapper) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        Map mapJson = new LinkedHashMap<String, String>();
        mapJson = mapper.readValue(new File(filePath), Map.class);
        /*} catch (Exception e) {
            //throw new Exception(e);
            throw new Exception("File '" + filePath + "' does not parse");
        }*/


        System.out.println(mapJson);
        return mapJson; //parse(content);
    }
    public static Map createResult(Map map1, Map map2) {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>();
        var items2 = new ArrayList<String>();
        items1 = new ArrayList<>(map1.keySet());
        items2 = new ArrayList<>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);


        var itemsSorted = itemsUnion.stream().sorted().toList();
        System.out.println(itemsSorted);
        for (var key : itemsSorted) {
            System.out.println(key);
            if (!map1.containsKey(key)) {
                var value2 = map2.get(key);
                mapResult.put( "+ " + key, value2);
                continue;
            } else if (!map2.containsKey(key)){
                var value1 = map1.get(key);
                mapResult.put( "- " + key, value1);
                continue;
                //var value2 = map2.get(key);
            }
            var value1 = map1.get(key);
            var value2 = map2.get(key);
            if (value1.equals(value2)) {
                mapResult.put( key, value1);
            } else {
                mapResult.put( "- " + key, value1);
                mapResult.put( "+ " + key, value2);
            }
        }

        return mapResult;
    }

}
