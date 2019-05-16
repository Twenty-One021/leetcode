package solution;

/**
 * @ClassName Q5
 * @Description
 * @Author zhihui
 * @Date 2019/5/7 16:58
 * @Version 1.0
 */
public class Q5 {

    public static void main(String[] args) {
        String str = "ababd";
        System.out.println(longestPalindromic(str));
    }

    private static String longestPalindromic(String str) {
        int s = 0, e = 0;
        int n = str.length();
        boolean[][] pal = new boolean[n][n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0) {
                if (str.charAt(j) == str.charAt(i) && (i - j <= 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        s = j;
                        e = i + 1;
                    }
                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j--;
            }
            if (maxLen / 2 > n - i + 1) break;
        }
        return str.substring(s, e);
    }
}
