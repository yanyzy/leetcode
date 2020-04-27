package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 * <p>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * <p>
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * <p>
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * <p>
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * <p>
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * <p>
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * <p>
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomizedSet {
    
    private List<Integer> list;
    private Map<Integer, Integer> map;
    
    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(list.size(), val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = new Random().nextInt(list.size());
        return list.get(i);
    }
    
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(0);
        boolean param_2 = obj.insert(1);
        boolean param_3 = obj.remove(0);
        boolean param_4 = obj.insert(2);
        boolean param_5 = obj.remove(1);
        int param_6 = obj.getRandom();
        
        System.out.println(param_1 + "," + param_2 + "," + param_3 + "," + param_4 + "," + param_5 + "," + param_6);
    }
}


