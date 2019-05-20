package top.zhyee.java.leetcode.simple;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/5/20 下午5:38
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] rs = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int k = nums2[nums2.length - 1];
            if (nums1[i] == k) {
                rs[i] = -1;
                continue;
            }
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums2[j] > nums1[i]) {
                    k = nums2[j];
                }
                if (nums2[j] == nums1[i]) {
                    break;
                }
            }
            if (k > nums1[i]) {
                rs[i] = k;
            } else {
                rs[i] = -1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        System.out.println(Arrays.toString(nextGreaterElementI.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 2, 3, 4})));
    }
}
