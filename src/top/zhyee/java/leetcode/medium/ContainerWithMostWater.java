package top.zhyee.java.leetcode.medium;

/**
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ContainerWithMostWater {

    /**
     * 解题思路：
     * 使用双指针，一个指向头，一个指向尾
     * 因为无论是头指针移动，还是尾指针移动，都将使容器的底部变小（宽度变小）
     * 因此，移动指针时，我们移动高度较低的那一边，确保留下了较高的另一边
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int max = 0;
        while (leftIndex < rightIndex) {

            int hight = Math.min(height[leftIndex], height[rightIndex]);
            int width = rightIndex - leftIndex;

            max = Math.max(hight * width, max);

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return max;
    }
}
