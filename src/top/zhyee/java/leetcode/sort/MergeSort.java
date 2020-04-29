package top.zhyee.java.leetcode.sort;

import java.util.Arrays;


/**
 * 归并排序
 * <p>
 * 将数组分为左右两部分，分别对这两个部分进行归并排序
 * 直到最后的数组只有一个数，或者两个数
 */
public class MergeSort {
    public int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] right = Arrays.copyOfRange(arr, 0, mid);
        int[] left = Arrays.copyOfRange(arr, mid, arr.length);
        return mergeSort(sort(right), sort(left));
    }
    
    private int[] mergeSort(int[] right, int[] left) {
        int[] newInt = new int[right.length + left.length];
        
        int rightIndex = 0;
        int leftIndex = 0;
        int newIndex = 0;
        
        while (rightIndex < right.length && leftIndex < left.length) {
            if (right[rightIndex] < left[leftIndex]) {
                newInt[newIndex++] = right[rightIndex++];
            } else {
                newInt[newIndex++] = left[leftIndex++];
            }
        }
        
        if (rightIndex < right.length) {
            while (rightIndex < right.length) {
                newInt[newIndex++] = right[rightIndex++];
            }
        } else if (leftIndex < left.length) {
            while (leftIndex < left.length) {
                newInt[newIndex++] = left[leftIndex++];
            }
        }
        return newInt;
    }
}
