package top.zhyee.java.leetcode.medium;


/**
 * 面试题 10.09. 排序矩阵查找
 * <p>
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedMatrixSearchLCCI {
    
    /**
     * 从左上角开始遍历，如果目标值小于该值，那么返回 false， 因为左上角是最小的元素
     * 如果大于该值，那么遍历该列
     * 然后再跳到下一列
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int N = matrix.length;
        for (int i = 0; i < matrix[0].length; i++) {
            int index = 0;
            if (matrix[index][i] > target) {
                return false;
            } else if (matrix[index][i] < target) {
                while (index < N) {
                    if (matrix[index][i] == target) {
                        return true;
                    }
                    index++;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
