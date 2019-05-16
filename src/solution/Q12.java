package solution;

/**
 * @ClassName Q12
 * @Description
 * @Author zhihui
 * @Date 2019/3/25 18:00
 * @Version 1.0
 */
public class Q12 {

    public static final int num = 1994;

    public static enum intRomanEnum {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        int value;

        private intRomanEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        if (num > 3999) return null;
        StringBuilder mapBuilder = new StringBuilder();
        int quotient = 0;
        intRomanEnum[] values = intRomanEnum.values();
        for (int i = values.length - 1; i >= 0; i--) {
            quotient = num / values[i].getValue();
            while (quotient-- > 0) {
                mapBuilder.append(values[i].name());
            }
            num = num % values[i].getValue();
        }
        return mapBuilder.toString()
                .replaceAll("I{4}", "IV")
                .replaceAll("X{4}", "XL")
                .replaceAll("C{4}", "CD")
                .replaceAll("DCD", "CM")
                .replaceAll("LXL", "XC")
                .replaceAll("VIV", "IX");
    }
}
