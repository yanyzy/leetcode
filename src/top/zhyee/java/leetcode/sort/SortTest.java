package top.zhyee.java.leetcode.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int arr_1[] = new int[]{1, 4, 2, 6, 24, 66, 88, 34, 233, 97, 5, 22};
        int arr_2[] = new int[]{1, 4, 2, 6, 24, 66, 88, 34, 233, 97, 5};
//        new ShellSort().sort(arr_1);
//        new ShellSort().sort(arr_2);
//        System.out.println(Arrays.toString(arr_1));
//        System.out.println(Arrays.toString(arr_2));
    
//        System.out.println(Arrays.toString(new MergeSort().sort(arr_1)));
//        System.out.println(Arrays.toString(new MergeSort().sort(arr_2)));
        
//        new Quicksort().sort(arr_1);
//        new Quicksort().sort(arr_2);
//        System.out.println(Arrays.toString(arr_1));
    
        System.out.println(Arrays.toString(new CountingSort().countingSort(arr_1)));
        System.out.println(Arrays.toString(new CountingSort().countingSort(arr_2)));
    }
}
