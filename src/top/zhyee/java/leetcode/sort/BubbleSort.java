package top.zhyee.java.leetcode.sort;

/**
 * 冒泡排序
 * <p>
 * 两个相邻的元素相比较，有需要则掉换位置
 * 比较一轮以后，最大的元素会移动到末尾，因此下一轮循环时不需要再检查末尾元素
 */
public class BubbleSort {
    
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
