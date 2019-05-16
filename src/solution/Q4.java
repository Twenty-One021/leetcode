/**
 * 
 */
package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 
 * @author zhihui
 * @date 2019年3月18日 下午7:20:16
 *
 */
public class Q4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {-1};
		System.out.println(mediumSearch2(nums1, nums2));
	}

	// expected solution 1
	private static double mediumSearch2(int[] nums1, int[] nums2) {
		int quotient = (nums1.length + nums2.length) / 2;
		int remainder = (nums1.length + nums2.length) % 2;
		double result = 0;
		List<Integer> targets = new ArrayList<>();
		int counter = 0, cursor1 = 0, cursor2 = 0;
		while (counter <= quotient) {
			int target = 0;
			if (nums1.length == 0) {
				if (remainder == 1) return nums2[quotient] / 1.0;
				return (nums2[quotient - 1] + nums2[quotient]) / 2.0;
			}
			if (nums2.length == 0) {
				if (remainder == 1) return nums1[quotient] / 1.0;
				return (nums1[quotient - 1] + nums1[quotient]) / 2.0;
			}
			if (cursor1 >= nums1.length) {
				if (quotient - counter <= 1) targets.add(nums2[cursor2]);
				counter++;
				cursor2++;
				continue;
			}
			if (cursor2 >= nums2.length) {
				if (quotient - counter <= 1) targets.add(nums1[cursor1]);
				counter++;
				cursor1++;
				continue;
			}
			if (nums1[cursor1] < nums2[cursor2]) {
				target = nums1[cursor1];
				cursor1++;
			} else {
				target = nums2[cursor2];
				cursor2++;
			}
			if (quotient - counter <= 1) targets.add(target);
			counter++;
		}
		System.out.println(targets);
		if (remainder == 0) {
			result = (targets.get(0) + targets.get(1)) / 2.0;
		} else {
			result = targets.get(1) / 1.0;
		}
		return result;
	}

	public static double mediumSearch(int[] nums1, int[] nums2) {
		if (nums1.length == 1 && nums2.length == 1)
			return (nums1[0] + nums2[0]) / 2.0;
		int target = (nums1.length + nums2.length) / 2;
		int counter = 0;
		int cursor1 = 0;
		int cursor2 = 0;
		int flag = 0;
		while (counter < target) {
			if (cursor1 >= nums1.length - 1) {
				counter++;
				flag = 2;
				if (!(counter < target))
					break;
				cursor2++;
				continue;
			}
			if (cursor2 >= nums2.length - 1) {
				counter++;
				flag = 1;
				if (!(counter < target))
					break;
				cursor1++;
				continue;
			}
			if (nums1[cursor1] > nums2[cursor2]) {
				cursor2++;
				flag = 2;
			} else {
				cursor1++;
				flag = 1;
			}
			counter++;
		}
		System.out.println(cursor1);
		System.out.println(cursor2);
		System.out.println(flag);
		if ((nums1.length + nums2.length) % 2 == 0) {
			int a, b;
			if (flag == 1) {
				a = nums1[cursor1];
				b = Integer.min(nums1[cursor1 - 1], nums2[cursor2]);
			} else {
				a = nums2[cursor2];
				b = Integer.min(nums2[cursor2 - 1], nums1[cursor1]);
			}
			return (a + b) / 2.0;
		} else {
			if (flag == 1)
				return nums1[cursor1];
			return nums2[cursor2];
		}
	}
}
