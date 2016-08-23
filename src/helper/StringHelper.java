package helper;

import java.util.ArrayList;

/**
 * Created by mladen on 11/07/16.
 */
public class StringHelper {


    /**
     *
     * @param string
     * @return
     */
    public static String deQuote(String string) {
        return string.replaceAll("^\"|\"$", "");
    }

    public static String combine(ArrayList<String> fields, String delimiter) {
        String output = "";
        for (String field : fields) {
            output += field + delimiter;
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }

    public static String combine(ArrayList<String> fields) {
        return combine(fields, ",");
    }
}
