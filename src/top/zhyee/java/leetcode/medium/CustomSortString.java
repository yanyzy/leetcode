package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * 791. 自定义字符串排序
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 *
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 *
 * 返回任意一种符合条件的字符串T。
 *
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 * 注意:
 *
 * S的最大长度为26，其中没有重复的字符。
 * T的最大长度为200。
 * S和T只包含小写字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/custom-sort-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CustomSortString {

    /**
     * 笨方法
     * 先循环找出在 S 中有的值，再与剩下的拼接在一起
     * @param S
     * @param T
     * @return
     */
    public String customSortString(String S, String T) {
        List<Character> list1 = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    list1.add(S.charAt(i));
                    T = T.replaceFirst(String.valueOf(T.charAt(j)), " ");
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list1) {
            stringBuilder.append(character);
        }
        stringBuilder.append(T);
        return stringBuilder.toString().replaceAll(" ","");
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba", "abcd"));
    }
}
