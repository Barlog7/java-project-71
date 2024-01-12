package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


import static hexlet.code.Parser.checkNull;


public class DiffBuilder {
    public static final String ADD = "ADDED#";
    public static final String CHANGE_FROM = "CHANGED FROM#";
    public static final String CHANGE_TO = "CHANGED TO#";
    public static final String DELETE = "DELETED#";
    public static final String NOT_CHANGE = "UNCHANGED#";
    public static Map createResult(Map map1, Map map2) throws JsonProcessingException {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();



        for (var key : itemsSorted) {

            var value1 = checkNull(map1.get(key));
            var value2 = checkNull(map2.get(key));
            String formatText = "";

            if (!map1.containsKey(key)) {

                mapResult.put(ADD + key, value2);
            } else if (!map2.containsKey(key)) {

                mapResult.put(DELETE + key, value1);
            } else if (value1.equals(value2)) {
                mapResult.put(NOT_CHANGE + key, value1);

            } else {

                mapResult.put(CHANGE_FROM + key, value1);
                mapResult.put(CHANGE_TO + key, value2);
            }
        }

        return mapResult;

    }
}
