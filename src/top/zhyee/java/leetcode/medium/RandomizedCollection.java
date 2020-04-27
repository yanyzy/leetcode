package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//todo
public class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return map.get(val).size() == 1;
    }
    
    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        Set<Integer> integers = map.get(val);
        int index = integers.iterator().next();
        
        //删除一个元素
        int last = list.get(list.size() - 1);
        list.set(index, last);
        integers.remove(index);
        map.get(last).remove(list.size() - 1);
        map.get(last).add(index);
        list.remove(list.size() - 1);
        return true;
    }
    
    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
    
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(4);
        boolean param_2 = obj.insert(3);
        boolean param_3 = obj.insert(4);
        boolean param_4 = obj.insert(2);
        boolean param_5 = obj.insert(4);
        boolean param_6 = obj.remove(4);
        boolean param_7 = obj.remove(3);
        boolean param_8 = obj.remove(4);
        boolean param_9 = obj.remove(4);
        System.out.println(param_1 + "," + param_2 + "," + param_3 + "," + param_4 + "," + param_5 + "," + param_6 + "," + param_7 + "," + param_8 + "," + param_9);
    }
}
