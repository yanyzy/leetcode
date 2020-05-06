package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumIII {
    
    /**
     * 仍然是回溯法
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum3(k, n, 1, lists, new ArrayList<>());
        return lists;
    }
    
    private void combinationSum3(int k, int n, int begin, List<List<Integer>> lists, List<Integer> integers) {
        if (begin > 9 || n <= 0 || integers.size() > k) {
            return;
        }
        for (int i = begin; i < 10; i++) {
            int newTarget = n - i;
            List<Integer> list = new ArrayList<>(integers);
            list.add(i);
            if (newTarget == 0 && list.size() == k) {
                lists.add(list);
            }
            combinationSum3(k, newTarget, i + 1, lists, list);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 15));
    }
}
