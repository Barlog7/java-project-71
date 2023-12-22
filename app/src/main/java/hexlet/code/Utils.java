package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Utils {
    public static String mapToString(Map<String, String> map) {
        StringBuilder stringReturn = new StringBuilder("{" + "\n");
        var entries = map.entrySet();
        for (var entry : entries) {
            stringReturn.append(entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n");
        }
        stringReturn.append("}");
        return stringReturn.toString();
    }
    public static Path getFixturePath(String fileName) {
        /*return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();*/
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }
}
