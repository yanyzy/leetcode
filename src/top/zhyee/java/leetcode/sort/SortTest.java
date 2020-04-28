package top.zhyee.java.leetcode.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int arr_1[] = new int[]{1, 4, 2, 6, 24, 66, 88, 34, 233, 97, 5, 22};
        new SelectionSort().sort(arr_1);
        System.out.println(Arrays.toString(arr_1));
    }
}
