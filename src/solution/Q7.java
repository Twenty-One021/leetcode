/**
 * 
 */
package solution;

/**
 * @Description 
 * @author zhihui
 * @date 2019��3��15�� ����6:11:54
 *
 */
public class Q7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		reverse(1534236469);
		reverse(-2147483412);
	}
	
	public static int reverse(int x) {
		int digit;
		int overflow = x;
		int result = 0;
		while (overflow != 0) {
			digit = overflow % 10;
			overflow = overflow /10;
			System.out.println("digit: " + digit);
			System.out.println("overflow: " + overflow);
			if ((x > 0 && (Integer.MAX_VALUE - digit) / 10 < result) || (x < 0 && (Integer.MIN_VALUE - digit) / 10 > result))
				return 0;
			result = digit + result * 10;
			System.out.println("result: " + result);
		}
		System.out.println(result);
		return result;
	}

}
