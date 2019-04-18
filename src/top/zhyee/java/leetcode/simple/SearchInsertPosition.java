package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/27 上午10:01
 */
public class SearchInsertPosition {

    /**
     * 对有序数组的插入操作
     * 二分查找会更快
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1}, 0));
    }
}
