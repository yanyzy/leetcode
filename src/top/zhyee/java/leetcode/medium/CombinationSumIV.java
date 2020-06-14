package top.zhyee.java.leetcode.medium;

public class CombinationSumIV {
    
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        
        int total = 0;
    
        for (int num : nums) {
            int newTarget = target - num;
            total = total + combinationSum4(nums, newTarget);
        }
        return total;
    }
    
    //    /**
//     * 回溯法，超时
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    int total = 0;
//
//    public int combinationSum4(int[] nums, int target) {
//        combinationSum(nums, target);
//        return total;
//    }
//
//    private void combinationSum(int[] nums, int target) {
//        if (target <= 0) {
//            return;
//        }
//        for (int num : nums) {
//            int newTarget = target - num;
//            if (newTarget == 0) {
//                total++;
//            } else if (newTarget < 0) {
//                continue;
//            }
//            combinationSum4(nums, newTarget);
//        }
//    }
    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
