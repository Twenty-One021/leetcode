package solution;

/**
 * @ClassName Q27
 * @Description
 * @Author zhihui
 * @Date 2019/5/13 9:56
 * @Version 1.0
 */
public class Q27 {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 2};
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    private static int removeElement(int[] nums, int val) {
        int cursor0 = 0, cursor1 = 1, len = nums.length;
        for (; cursor0 < len && cursor1 < len; cursor0++)
            if (nums[cursor0] == val) {
                if (cursor0 >= cursor1) cursor1 = cursor0 + 1;
                while (cursor1 < len && nums[cursor1] == val) cursor1++;
                if (len == cursor1) return cursor0;
                int temp = nums[cursor0];
                nums[cursor0] = nums[cursor1];
                nums[cursor1] = temp;
                cursor1++;
            }
        return !(cursor0 < len) || nums[cursor0] == val ? cursor0 : cursor0 + 1;
    }
}
