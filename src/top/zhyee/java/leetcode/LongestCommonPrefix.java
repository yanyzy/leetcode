package top.zhyee.java.leetcode;


public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if (strs[0].isEmpty() && strs.length == 1) {
            return "";
        }
        String shortest = strs[0];//以第一个字符串为准做对比
        for (int i = 0; i < strs.length; i++) {
            shortest = this.getShortest(strs[i], shortest);
        }
        return shortest;

    }

    private String getShortest(String s, String shortest) {
        if (s.indexOf(shortest) != 0) {
            shortest = shortest.substring(0, shortest.length() - 1);
            if (shortest.isEmpty()) {
                return "";
            }
            shortest = getShortest(s, shortest);//递归调用直到符合标准
        }
        return shortest;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }
}
