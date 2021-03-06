package top.zhyee.java.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    
    /**
     * 遍历两次
     * 用栈先将第一次没找到更大的元素保存下来其索引
     * 第二次遍历只出栈不入栈
     * 然后将栈中剩余的索引位置 -1 ，因为遍历两遍后仍未找到更大值，则没有更大值了
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ints = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                ints[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        for (int num : nums) {
            while (!stack.empty() && num > nums[stack.peek()]) {
                ints[stack.peek()] = num;
                stack.pop();
            }
        }
        
        while (!stack.empty()) {
            ints[stack.peek()] = -1;
            stack.pop();
        }
        
        return ints;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1})));
    }
    
}
