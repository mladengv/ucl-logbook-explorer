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

    /**
     *
     * @param string
     * @return
     */
    public static String enQuote(String string) {
        return '"' + string + '"';
    }

    /**
     * Combine by concatenating an array using a delimiter.
     *
     * @param fields The array of strings to combine.
     * @param delimiter The delimiter to use.
     * @return The concatenated string.
     */
    public static String combine(ArrayList<String> fields, String delimiter) {
        String output = "";
        for (String field : fields) {
            output += field + delimiter;
        }
        output = output.substring(0, output.length() - delimiter.length());
        return output;
    }

    /**
     *
     * @param fields
     * @return
     */
    public static String combine(ArrayList<String> fields) {
        return combine(fields, ",");
    }
}
