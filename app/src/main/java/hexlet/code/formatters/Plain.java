package hexlet.code.formatters;

public class Plain {
    public static String formatedTextSPlain(String key, Object value, String type) {
        String sFormat = "";
        String typeSign = "";
        switch (type) {
            case ("add") :
                sFormat = "Property '" + key + "' was added with value: " + formatingValue(value) + "\n";
                //sFormat = "  " + typeSign + " " + key + ": " + String.valueOf(value) + "\n";
                break;
            case ("remove") :
                sFormat = "Property '" + key + "' was removed" + "\n";
                //typeSign = "-";
                break;
            default:
                sFormat = "";
        }
        return sFormat;
    }
    public static String formatedTextSPlain(String key, Object value1, Object value2) {
        String sFormat = "";
        sFormat = "Property '"
                    + key
                    + "' was updated. From "
                    + formatingValue(value1)
                    + " to " + formatingValue(value2) + "\n";
        return sFormat;
    }
    public static String formatingValue(Object value) {
        String returnValue = "";

        if (value.equals("null")) {
            returnValue = String.valueOf(value);
        } else if (value instanceof String) {
            returnValue = "'" + String.valueOf(value) + "'";
        } else if (value instanceof Integer || value instanceof Boolean) {
            returnValue = String.valueOf(value);
        } else {
            returnValue = "[complex value]";
        }
        return returnValue;
    }
    public static StringBuilder deteleEndRow(StringBuilder text) {
        text = text.deleteCharAt(text.length() - 1);
        return text;
    }
}
