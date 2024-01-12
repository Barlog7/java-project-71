package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import java.util.Map;

import static hexlet.code.DiffBuilder.createResult;

import static hexlet.code.Parser.getData;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {


        Map mapFirstFile = new LinkedHashMap<String, String>();
        Map mapSecondFile = new LinkedHashMap<String, String>();

        String typeFile1 = "";
        String typeFile2 = "";
        typeFile1 = findTypeFile(filePath1);
        typeFile2 = findTypeFile(filePath2);

        String content1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String content2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());
        mapFirstFile = getData(content1, typeFile1);
        mapSecondFile = getData(content2, typeFile2);


        Map resultMap = createResult(mapFirstFile, mapSecondFile);
        String stringReturn = Formater.render(resultMap, format);

        return  stringReturn;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String findTypeFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String typeFile = "";

        String sName = path.getFileName().toString();
        int indexDot = sName.lastIndexOf(".");
        switch (sName.substring(indexDot)) {
            case (".yml") :
                typeFile = "yml";
                break;
            case (".json") :
                typeFile = "json";
                break;
            default:
                throw new Exception("File '" + path + "' not .yml or .json type");
        }

        return typeFile;
    }

}
