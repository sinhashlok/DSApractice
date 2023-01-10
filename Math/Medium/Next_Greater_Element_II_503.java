package DSApractice.Math.Medium;

import java.util.Stack;

public class Next_Greater_Element_II_503 {

    // loop once -> next greater in normal array
    // loop twice -> next greater in circular array
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }

            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }

        return res;
    }
}