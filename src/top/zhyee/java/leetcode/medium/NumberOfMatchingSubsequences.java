package top.zhyee.java.leetcode.medium;

/**
 * 792. 匹配子序列的单词数
 *
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 * 注意:
 *
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-matching-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubsequence(words[i], S)) {
                count++;
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                if (sIndex == s.length() - 1) {
                    return true;
                }
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return false;
    }
}
