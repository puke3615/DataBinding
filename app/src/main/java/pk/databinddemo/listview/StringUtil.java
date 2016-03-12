package pk.databinddemo.listview;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark
 */
public class StringUtil {

    public static String format(String str) {
        if (str != null && str.contains("username")) {
            str = str.replaceAll("username", "");
        }
        return str;
    }

}
