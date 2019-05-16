package solution;

import java.util.List;
import java.util.function.Function;

/**
 * @ClassName Q14
 * @Description
 * @Author zhihui
 * @Date 2019/3/22 15:13
 * @Version 1.0
 */
public class Q14 {
    public static void main(String[] args) {
        String[] arr = {"flow", "flower", "flight"};
        String maxPrefix = arr[0];
        int lastOffset = 0;
        for (String item : arr) {
            for (lastOffset = 0; lastOffset < maxPrefix.length() && lastOffset < item.length(); lastOffset++) {
                if (maxPrefix.charAt(lastOffset) != item.charAt(lastOffset)) break;
            }
            if (lastOffset == 0) break;
        }
        maxPrefix = maxPrefix.substring(0, lastOffset);
        System.out.println(maxPrefix);
    }

}
