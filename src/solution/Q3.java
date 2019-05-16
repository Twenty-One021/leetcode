/**
 * 
 */
package solution;

/**
 * @Description 
 * @author zhihui
 * @date 2019年3月18日 下午6:25:38
 *
 */
public class Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "smaiinflfhzgxfatjfjlhzavobrgapcd";
//		String string = "abcabcbb";
		System.out.println(maxLength(string));
	}

	public static int maxLength(String string) {
		if (string == null || string.length() == 0)
			return 0;
//		char[] charArray = string.toCharArray();
		int first = 0;
		int maxLength = 1;
		for (int last = 1; last < string.length(); last++) {
			int indexOf = string.substring(first, last).indexOf(string.charAt(last));
			if (indexOf != -1) 
				first = first + indexOf + 1;
			if (last - first + 1 > maxLength) 
				maxLength = last - first + 1;
		}
		return maxLength;
	}
	
}
