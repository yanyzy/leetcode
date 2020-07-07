package top.zhyee.java.leetcode.simple;

public class CompressStringLCCI {
    
    public String compressString(String S) {
        if (S.length() == 0) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Character c = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == c) {
                count++;
            } else {
                stringBuilder.append(c);
                stringBuilder.append(count);
                c = S.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(c);
        stringBuilder.append(count);
        String s = stringBuilder.toString();
        if (s.length() >= S.length()) {
            return S;
        }
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(new CompressStringLCCI().compressString("aabcccccaa"));
    }
}
