package top.zhyee.java.leetcode.sort;

/**
 * 计数排序
 *
 * 首先找出数组的最大值
 * 根据最大值构建新的数组
 * 遍历待排序数组，将元素 i 存到新数组的第 i 位。每增加相同的 i , 新数组的 arr[i]++，用于计算这个元素出现的次数
 * 遍历新数组，将数值填充回原数组
 */
public class CountingSort {
    
    public int[] countingSort(int[] arr) {
        //先找出数组的范围
        int max = arr[0];
        for (int value : arr) {
            max = Math.max(max, value);
        }
        
        int[] temp = new int[max + 1];
        for (int value : arr) {
            temp[value]++;
        }
        int arrIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                while (temp[i] > 0) {
                    arr[arrIndex] = i;
                    temp[i]--;
                    arrIndex++;
                }
            }
        }
        
        return arr;
    }
}
