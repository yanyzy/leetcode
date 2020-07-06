package top.zhyee.java.leetcode.simple;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                a = 1;
            } else if (A[i] > A[i - 1]){
                b = 1;
            }
        }
        return a + b != 2;
    }
}
