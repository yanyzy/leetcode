package top.zhyee.java.leetcode.sort;

/**
 * 选择排序
 * <p>
 * 每次从数组中挑选出最小的元素放到排好的元素后
 */
public class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                //最好是保存最小元素的索引，只进行一次交换
                if (arr[j] < min) {
                    int temp = arr[j];
                    arr[j] = min;
                    arr[i] = temp;
                    min = arr[i];
                }
            }
        }
    }
}
