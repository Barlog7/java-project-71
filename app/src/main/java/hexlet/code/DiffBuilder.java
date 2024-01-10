package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//import static hexlet.code.Formater.addStartEndSign;
//import static hexlet.code.Formater.formatedText;
import static hexlet.code.Parser.checkNull;
//import static hexlet.code.formatters.Json.formatToJson;

public class DiffBuilder {
    public static String createResult(Map map1, Map map2, String typeFormat) throws JsonProcessingException {
        Map mapResult = new LinkedHashMap<String, String>();
        var items1 = new ArrayList<String>(map1.keySet());
        var items2 = new ArrayList<String>(map2.keySet());
        var itemsUnion = CollectionUtils.union(items1, items2);
        //
        var itemsSorted = itemsUnion.stream().sorted().toList();

        //StringBuilder stringReturn = new StringBuilder();

        for (var key : itemsSorted) {

            var value1 = checkNull(map1.get(key));
            var value2 = checkNull(map2.get(key));
            String formatText = "";

            if (!map1.containsKey(key)) {
                //formatText = formatedText(key, value2, "add", typeFormat);
                //stringReturn.append(formatText);
                mapResult.put("  + " + key, value2);
            } else if (!map2.containsKey(key)) {
                //formatText = formatedText(key, value1, "remove", typeFormat);
                //stringReturn.append(formatText);
                mapResult.put("  - " + key, value1);
            } else if (value1.equals(value2)) {
                mapResult.put("    " + key, value1);
                //formatText = formatedText(key, value1, "not change", typeFormat);
                //stringReturn.append(formatText);
            } else {
                //formatText = formatedText(key, value1, value2, typeFormat);
                //stringReturn.append(formatText);

                mapResult.put("  - " + key, value1);
                mapResult.put("  + " + key, value2);
            }
        }
        /*if (typeFormat.equals("json")) {
            return formatToJson(mapResult);
        }
        stringReturn = addStartEndSign(stringReturn, typeFormat);*/
        String stringReturn = Formater.render(mapResult, typeFormat);
        return stringReturn;
    }
}
