package hexlet.code;


import java.util.LinkedHashMap;

import java.util.Map;

import static hexlet.code.Parser.createResult;
import static hexlet.code.Parser.getData;


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

        String returnString = createResult(mapFirstFile, mapSecondFile, format);

        return  returnString;
    }


}
