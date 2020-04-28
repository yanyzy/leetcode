package top.zhyee.java.leetcode.sort;


/**
 * 插入排序
 * <p>
 * 遍历每一个元素，当发现其小于前面的元素，则不断将前面的元素向后移动
 */
public class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i - 1;
            int current = arr[i];
            while (index >= 0 && current < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = current;
        }
    }
}
