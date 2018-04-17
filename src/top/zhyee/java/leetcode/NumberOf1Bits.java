package top.zhyee.java.leetcode;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int i = 0;
        String s = Integer.toBinaryString(n);
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='1'){
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(1));
    }
}
