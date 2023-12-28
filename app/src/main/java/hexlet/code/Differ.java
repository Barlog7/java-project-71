package hexlet.code;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;

//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.LinkedHashMap;
//import java.util.ArrayList;
import java.util.Map;

import static hexlet.code.Parser.createResult;
import static hexlet.code.Parser.getData;
import static hexlet.code.Utils.mapToString;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) {


        Map mapFirstFile = new LinkedHashMap<String, String>();
        Map mapSecondFile = new LinkedHashMap<String, String>();

        try {
            mapFirstFile = getData(filePath1);
            mapSecondFile = getData(filePath2);
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Map result = createResult(mapFirstFile, mapSecondFile);
        String returnString = createResult(mapFirstFile, mapSecondFile, format);
        //String returnString = result.entrySet().stream().flatMap(y -> y).collect(Collectors.joining(" "));
        //String returnString = StringUtils.join(result);
        //String returnString = mapToString(result);
        //System.out.println(returnString);
        return  returnString;
    }


}
