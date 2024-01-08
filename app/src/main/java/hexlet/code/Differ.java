package hexlet.code;


import java.util.LinkedHashMap;

import java.util.Map;

import static hexlet.code.DiffBuilder.createResult;
//import static hexlet.code.Parser.createResult;
import static hexlet.code.Parser.getData;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {


        Map mapFirstFile = new LinkedHashMap<String, String>();
        Map mapSecondFile = new LinkedHashMap<String, String>();
        mapFirstFile = getData(filePath1);
        mapSecondFile = getData(filePath2);


        String returnString = createResult(mapFirstFile, mapSecondFile, format);

        return  returnString;
    }


}
