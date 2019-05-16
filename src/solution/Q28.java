package solution;

/**
 * @ClassName Q28
 * @Description
 * @Author zhihui
 * @Date 2019/5/15 10:45
 * @Version 1.0
 */
public class Q28 {
    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("hello", "ll"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || needle.length() > haystack.length()) {
            return -1;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < len2; j++) {
                flag = haystack.charAt(i + j) == needle.charAt(j);
                if (!flag) break;
            }
            if (flag) return i;
        }
        return -1;
    }
}
