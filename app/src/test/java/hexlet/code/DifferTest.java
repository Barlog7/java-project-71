package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
//import static hexlet.code.Utils.getFixturePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testGenerate() {
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        Path path1 = getFixturePath("file1.json");
        Path path2 = getFixturePath("file2.json");
        //String  filePath1 = "/home/barlog/java-project-71/app/src/test/resources/file1.json";
        //String  filePath2 = "/home/barlog/java-project-71/app/src/test/resources/file2.json";
        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);
        //System.out.println("expected = " + expected);
        //System.out.println("path1 =" + path1);
        //System.out.println("path2 =" + path2);
        var actual = generate(filePath1, filePath2);
        //System.out.println("actual = " + actual);
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateYml() {
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        //Path path1 = getFixturePath("file1.yml");
        //Path path2 = getFixturePath("file2.yml");
        Path path1 = getFixturePath("file1.yml");
        Path path2 = getFixturePath("file2.yml");
        //String  filePath1 = "/home/barlog/java-project-71/app/src/test/resources/file1.json";
        //String  filePath2 = "/home/barlog/java-project-71/app/src/test/resources/file2.json";
        //filepath1 = "/home/barlog/java-project-71/app/src/test/resources/file1.yml";
        //filepath1 = "/home/barlog/java-project-71/app/src/test/resources/file2.yml";
        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);
        //System.out.println("expected = " + expected);
        //System.out.println("path1 =" + path1);
        //System.out.println("path2 =" + path2);
        var actual = generate(filePath1, filePath2);
        //System.out.println("actual = " + actual);
        assertEquals(expected, actual);
    }
    public static Path getFixturePath(String fileName) {
        /*return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();*/
       // Path path = Paths.get("src", "test", "resources", fileName);
        //Path Abspath = path.toAbsolutePath();
        //Path NormalPath = path.normalize();
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }
}
