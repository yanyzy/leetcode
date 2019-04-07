package top.zhyee.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/4/7 下午11:27
 */

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++) {
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

        return lists.get(rowIndex);
    }
}
