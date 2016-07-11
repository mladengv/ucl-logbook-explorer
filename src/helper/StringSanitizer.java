package helper;

/**
 * Created by mladen on 11/07/16.
 */
public class StringSanitizer {


    /**
     *
     * @param string
     * @return
     */
    public static String deQuote(String string) {
        return string.replaceAll("^\"|\"$", "");
    }
}
