package solution;

import java.text.DecimalFormat;

/**
 * @ClassName Q50
 * @Description
 * @Author zhihui
 * @Date 2019/5/6 18:38
 * @Version 1.0
 */
public class Q50 {
    public static void main(String[] args) {
        double x = 1.000;
        int n = -2147483648;
        double result;
        // my expected solution
        int eBase = 8192;
        if (n < 0) n += 1;
        int absN = abs(n);
        result = myAnotherPow(x, absN);
        if (n < 0) result = 1.0 / (x * result);
        System.out.println(result);
    }

    // TODO could be optimized with tail recursion
    static double myAnotherPow(double x, int n) {
        int eBase = 8192;
        if (n <= eBase) return myPowRecur(x, n, 1);
        return myAnotherPow(myAnotherPow(x, eBase), n / eBase) * myAnotherPow(x, n % eBase);
    }

    private static int abs(int n) {
        return n > 0 ? n : -n;
    }

    public static double myPow(double x, int n) {
        return myPowRecur(x, n, 1);
    }

    private static double myPowRecur(double x, int n, double base) {
        if (n == 0) return base;
        return myPowRecur(x, n - 1, x * base);
    }
}
