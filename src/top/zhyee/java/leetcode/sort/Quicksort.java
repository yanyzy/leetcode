package top.zhyee.java.leetcode.sort;

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
