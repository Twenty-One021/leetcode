/**
 * 
 */
package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @author zhihui
 * @date 2019年3月20日 上午10:10:09
 *
 */
public class Q9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 123321;
		System.out.println(isPalindrome(input));
	}

	private static boolean isPalindrome(int x) {
		if (x < 0) return false;
		int base = 10;
		int quotient = x / base;
		if (quotient == 0) return true;
		int tailR = x % base;
		if (tailR == 0) return false;
		while (quotient / tailR >= 100) {
			tailR = tailR * base + quotient % base;
			quotient = quotient / base;
		}
		return quotient == tailR || quotient / base == tailR;
	}

}
