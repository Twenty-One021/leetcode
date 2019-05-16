package solution;

/**
 * @ClassName Q26
 * @Description
 * @Author zhihui
 * @Date 2019/5/10 18:28
 * @Version 1.0
 */
public class Q26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int cursor0 = 0, cursor1 = 1, len = nums.length;
        while (cursor1 < len && nums[cursor0] < nums[len - 1]) {
            if (nums[cursor0] < nums[cursor1]) {
                nums[++cursor0] = nums[cursor1];
            }
            cursor1++;
        }
        return cursor0 + 1;
    }
}
