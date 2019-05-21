package top.zhyee.java.leetcode.medium;

import java.util.*;

/**
 * @author zhyee
 * @date 2019/5/21 下午2:34
 */


/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] copyStr = strs.clone();
        for (int i = 0; i < copyStr.length; i++) {
            String[] s = copyStr[i].split("");
            Arrays.sort(s);
            copyStr[i] = String.join("", s);
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < copyStr.length; i++) {
            List<String> stringList = new ArrayList<>();
            if (map.containsKey(copyStr[i])) {
                stringList = map.get(copyStr[i]);
            }
            stringList.add(strs[i]);
            map.put(copyStr[i], stringList);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
