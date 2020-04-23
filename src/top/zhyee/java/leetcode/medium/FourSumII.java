package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * <p>
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSumII {
    /**
     * 分解成两数和
     * 首先将 A 与 B 的所有可能的和放进 map ，并记录出现次数
     * 再讲 C D 的所有可能和与 map 中的值对应，获得能组成 0 的次数
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {
            return 0;
        }
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : A) {
            for (int i : B) {
                int count = value + i;
                map.merge(count, 1, Integer::sum);
            }
        }
        for (int value : C) {
            for (int i : D) {
                int count = -(value + i);
                if (map.containsKey(count)) {
                    total = total + map.get(count);
                }
            }
        }
        return total;
    }
}
