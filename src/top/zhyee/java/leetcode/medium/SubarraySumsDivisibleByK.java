package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySumsDivisibleByK {
    /**
     * 迷迷糊糊地做出来了
     * 用到了前缀和、哈希表
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int total = 0;
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum[0] % K, 1);
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = A[i] + sum[i];
            int i1 = sum[i + 1] % K;
            if (i1 < 0) {
                i1 = i1 + K;
            }
            if (map.get(i1) != null) {
                total = total + map.get(i1);
                map.put(i1, map.get(i1) + 1);
            } else {
                map.put(i1, 1);
            }
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        System.out.println(-2 % 6);
    }
}
