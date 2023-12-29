package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;

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

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "stylish");

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

        Path path1 = getFixturePath("file1.yml");
        Path path2 = getFixturePath("file2.yml");

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateWithObjects() {

        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        Path path1 = getFixturePath("file3.json");
        Path path2 = getFixturePath("file4.json");

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateWithObjectsYml() {

        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        Path path1 = getFixturePath("file3.yml");
        Path path2 = getFixturePath("file4.yml");

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual);
    }
    public static Path getFixturePath(String fileName) {

        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }
    @Test
    public void testGenerateWithObjectsPlain() {
        var expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        Path path1 = getFixturePath("file3.json");
        Path path2 = getFixturePath("file4.json");

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "plain");

        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateWithObjectsJson() {
        var expected = "{\n"
                + "  \"    chars1\" : [ \"a\", \"b\", \"c\" ],\n"
                + "  \"  - chars2\" : [ \"d\", \"e\", \"f\" ],\n"
                + "  \"  + chars2\" : false,\n"
                + "  \"  - checked\" : false,\n"
                + "  \"  + checked\" : true,\n"
                + "  \"  - default\" : \"null\",\n"
                + "  \"  + default\" : [ \"value1\", \"value2\" ],\n"
                + "  \"  - id\" : 45,\n"
                + "  \"  + id\" : \"null\",\n"
                + "  \"  - key1\" : \"value1\",\n"
                + "  \"  + key2\" : \"value2\",\n"
                + "  \"    numbers1\" : [ 1, 2, 3, 4 ],\n"
                + "  \"  - numbers2\" : [ 2, 3, 4, 5 ],\n"
                + "  \"  + numbers2\" : [ 22, 33, 44, 55 ],\n"
                + "  \"  - numbers3\" : [ 3, 4, 5 ],\n"
                + "  \"  + numbers4\" : [ 4, 5, 6 ],\n"
                + "  \"  + obj1\" : {\n"
                + "    \"nestedKey\" : \"value\",\n"
                + "    \"isNested\" : true\n"
                + "  },\n"
                + "  \"  - setting1\" : \"Some value\",\n"
                + "  \"  + setting1\" : \"Another value\",\n"
                + "  \"  - setting2\" : 200,\n"
                + "  \"  + setting2\" : 300,\n"
                + "  \"  - setting3\" : true,\n"
                + "  \"  + setting3\" : \"none\"\n"
                + "}";
        Path path1 = getFixturePath("file3.json");
        Path path2 = getFixturePath("file4.json");

        String  filePath1 = String.valueOf(path1);
        String  filePath2 = String.valueOf(path2);

        var actual = generate(filePath1, filePath2, "json");

        assertEquals(expected, actual);
        System.out.println(actual);
    }
}
