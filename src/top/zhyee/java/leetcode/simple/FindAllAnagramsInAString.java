package top.zhyee.java.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/5/21 下午3:46
 */

//todo 极端情况未通过

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        String[] ptemp = p.split("");
        Arrays.sort(ptemp);
        String pp = String.join("", ptemp);
        List<Integer> list = new ArrayList<>();
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() > s.length()) {
                break;
            }
            if (b) {
                if (s.charAt(i - 1) == s.charAt(i + p.length() - 1)) {
                    list.add(i);
                    b = true;
                    continue;
                }
            }
            String temp = s.substring(i, i + p.length());
            String[] stemp = temp.split("");
            Arrays.sort(stemp);
            if (pp.equals(String.join("", stemp))) {
                list.add(i);
                b = true;
            } else {
                b = false;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("aaaaaaaaaaaaaa", "aaa"));
    }
}
