package solution;

/**
 * @ClassName Q35
 * @Description
 * @Author zhihui
 * @Date 2019/5/9 15:38
 * @Version 1.0
 */
public class Q35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * @author zhihui
     * @date 2019/5/9
     * @param nums
     * @param target
     * @return int
     */
    private static int searchInsert(int[] nums, int target) {
        return getIndex(nums, target, 0, nums.length - 1);
    }

    private static int getIndex(int[] nums, int target, int s, int e) {
        if (nums[s] >= target) return s;
        if (nums[e] < target) return e + 1;
        if (s == e) return nums[s] == target ? s : s + 1;
        int middle = (s + e) / 2;
        if (nums[middle] < target) return getIndex(nums, target, middle + 1, e);
        return getIndex(nums, target, s, middle);
    }
}
