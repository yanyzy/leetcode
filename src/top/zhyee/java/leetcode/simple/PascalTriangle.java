package top.zhyee.java.leetcode.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/4/7 下午10:51
 */


/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            if (lists.size() == 0) {
                lists.add(Collections.singletonList(1));
            } else {
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i) {
                        list.add(1);
                    } else {
                        list.add(lists.get(i - 2).get(j - 2) + lists.get(i - 2).get(j - 1));
                    }
                }
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(5));
    }
}
