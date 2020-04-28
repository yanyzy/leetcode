package top.zhyee.java.leetcode.sort;


/**
 * 希尔排序
 * <p>
 * 按步进将数组分为若干小组，对这些小组分别进行插入排序，再修改步进，直到步进为0
 */
public class ShellSort {
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
