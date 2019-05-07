package top.zhyee.java.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhyee
 * @date 2019/5/7 下午2:30
 */

/**
 * 961. 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 */
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        int n = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
            if(map.get(A[i])==n){
                return A[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        NRepeatedElementInSize2NArray nRepeatedElementInSize2NArray = new NRepeatedElementInSize2NArray();
        System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(new int[]{1,2,3,3}));
    }
}
