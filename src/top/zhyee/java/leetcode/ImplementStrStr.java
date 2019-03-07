package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/6 下午5:51
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int hlength = haystack.length();
        int nlength = needle.length();

        for (int i = 0; i <= hlength - nlength; i++) {
            int j;
            for (j = 0; j < nlength; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nlength) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        implementStrStr.strStr("mississippi", "mississippi");
    }
}
