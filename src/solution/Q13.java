package solution;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.ToIntFunction;

/**
 * @Description
 * @author zhihui
 * @date 2019年3月22日 上午9:35:08
 *
 */
public class Q13 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String string = "MCMXCIV";
        ToIntFunction<String> toIntFunction = (str) -> {
            switch (str) {
                case "I":
                    return 1;
                case "V":
                    return 5;
                case "X":
                    return 10;
                case "L":
                    return 50;
                case "C":
                    return 100;
                case "D":
                    return 500;
                case "M":
                    return 1000;
                default:
                    return 0;
            }
        };
        System.out.println(toIntFunction.applyAsInt("I"));
        OptionalInt reduce = Arrays.stream(new StringBuffer(string).reverse().toString().split("(?<=[IVXLCDM])(?=[IVXLCDM])")).mapToInt(toIntFunction).reduce((acc, item) -> {
            if (acc <= item)
                return acc + item;
            return acc - item;
        });
        if (reduce.isPresent())
            System.out.println(reduce.getAsInt());

        String string1 = "I";
        int[] array = Arrays.stream(string1.split("(?<=[IVXLCDM])(?=[IVXLCDM])")).mapToInt(toIntFunction).toArray();
        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) {
                result += array[i];
                continue;
            }
            if (array[i] < array[i + 1]) {
                result -= array[i];
                continue;
            }
            result += array[i];
        }
        System.out.println(result);
    }

}
