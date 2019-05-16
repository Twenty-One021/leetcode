package solution;

/**
 * @ClassName Q6
 * @Description
 * @Author zhihui
 * @Date 2019/3/25 17:31
 * @Version 1.0
 */
public class Q6 {

    public static final String s = "PAYPALISHIRING";
    public static final int numRows = 2;

    public static void main(String[] args) {
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int mod = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                stringBuilder.append(s.charAt(j));
                int supIndex = (j / mod + 1) * mod - (j % mod);
                if (supIndex < s.length() && i != 0 && i != numRows - 1) {
                    stringBuilder.append(s.charAt(supIndex));
                }
                j += mod;
            }
        }
        return stringBuilder.toString();
    }
}
