package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/4/2 下午4:15
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * <p>
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 解释 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> b = new ArrayList<>();
        while (K > 0) {
            int i = K % 10;
            b.add(0, i);
            K = K / 10;
        }

        int aIndex = A.length - 1;
        int bIndex = b.size() - 1;
        int next = 0;

        List<Integer> rs = new ArrayList<>();
        while (aIndex >= 0 && bIndex >= 0) {
            int add = A[aIndex] + b.get(bIndex) + next;
            next = 0;
            if (add >= 10) {
                next = add / 10;
                add = add % 10;
            }
            rs.add(0, add);
            aIndex--;
            bIndex--;
        }

        if (aIndex >= 0) {
            while (aIndex >= 0) {
                int add = A[aIndex] + next;
                next = 0;
                if (add >= 10) {
                    next = add / 10;
                    add = add % 10;
                }
                rs.add(0, add);
                aIndex--;
            }
        } else if (bIndex >= 0) {
            while (bIndex >= 0) {
                int add = b.get(bIndex) + next;
                next = 0;
                if (add >= 10) {
                    next = add / 10;
                    add = add % 10;
                }
                rs.add(0, add);
                bIndex--;
            }
        }

        if (next > 0) {
            rs.add(0, next);
        }

        return rs;
    }


    public static void main(String[] args) {

        AddToArrayFormOfInteger a = new AddToArrayFormOfInteger();
        System.out.println(a.addToArrayForm(new int[]{2, 7, 4}, 181));
    }
}
