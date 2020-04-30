package top.zhyee.java.leetcode.sort;

/**
 * 快排
 * <p>
 * 先选择一个基准值，使用两个指针遍历数组
 * 从左开始找到第一个比基准值大的数，从右开始找到第一个比基准值小的数，然后交换
 * 遍历结束，将基准值放到中间
 * 再将其左右两个数组进行快速排序
 */
public class Quicksort {
    public void sort(int[] arr) {
        quickSort(arr, 0, 1, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int start, int left, int right) {
        if (left > right) {
            return;
        }
        int p = arr[start];
        int copyRight = right;
        while (left < right) {
            if (arr[left] > p && arr[right] < p) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] > p) {
                right--;
            } else if (arr[right] < p) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        
        if (arr[left] < p) {
            arr[start] = arr[left];
            arr[left] = p;
        } else {
            left--;
            arr[start] = arr[left];
            arr[left] = p;
        }
        
        quickSort(arr, start, start + 1, left - 1);
        quickSort(arr, left + 1, left + 2, copyRight);
    }
    
    
}
