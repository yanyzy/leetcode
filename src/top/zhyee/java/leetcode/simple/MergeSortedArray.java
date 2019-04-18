package top.zhyee.java.leetcode.simple;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/3/24 下午9:30
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) {
            return;
        }

        int i = 0;
        int j = 0;

        while (j < n && i < m+j) {
            if (nums1[i] > nums2[j]) {
                //插入前一个位置
                insert(i, nums1, nums2[j]);
                j++;
            }
            i++;
        }

        if (j != n) {
            int k = 0;
            int x = m + j;
            while (j < n) {
                nums1[x + k] = nums2[j];
                k++;
                j++;
            }
        }
    }

    private void insert(int n, int[] nums1, int m) {
        if (n < nums1.length) {
            int temp = nums1[n];
            nums1[n] = m;
            insert(n + 1, nums1, temp);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{4, 5, 6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
