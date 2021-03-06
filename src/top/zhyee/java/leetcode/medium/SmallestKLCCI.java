package top.zhyee.java.leetcode.medium;


/**
 * 面试题 17.14. 最小K个数
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestKLCCI {
    //冒泡排序超出时间限制，用希尔排序即可
    public int[] smallestK(int[] arr, int k) {
        sort(arr);
        int[] newArr = new int[k];
        k--;
        while (k >= 0) {
            newArr[k] = arr[k];
            k--;
        }
        return newArr;
    }
    
    public void sort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i = i / 2) {
            //分数组做插入排序
            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < arr.length; k = k + i) {
                    int preIndex = k - i;
                    int current = arr[k];
                    while (preIndex >= 0 && arr[preIndex] > current) {
                        arr[preIndex + i] = arr[preIndex];
                        preIndex = preIndex - i;
                    }
                    arr[preIndex + i] = current;
                }
            }
        }
    }
}
