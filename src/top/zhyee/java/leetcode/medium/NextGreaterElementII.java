package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementII {
    
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
