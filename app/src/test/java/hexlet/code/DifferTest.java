package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static hexlet.code.Differ.generate;
import static hexlet.code.Utils.getFixturePath;
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
        var actual = generate(filePath1, filePath2);
        assertEquals(expected, actual);
    }
}
