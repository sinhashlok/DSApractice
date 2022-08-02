// https://leetcode.com/problems/next-greater-element-i/

package DSApractice.StacknQueue.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I_496 {

        // My code
    public int[] nextGreaterElementMY(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            boolean flag = true;

            while (index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    nums1[i] = nums2[index];
                    flag = false;
                    break;
                }

                index++;
            }

            if (flag) {
                nums1[i] = -1;
            }
        }

        return nums1;
    }


    /*
        We use a stack to keep a decreasing sub-sequence, whenever we see a number x
        greater than stack.peek() we pop all elements less than x and for all the popped ones,
        their next greater element is x

        For example [9, 8, 7, 3, 2, 1, 6]
        The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater
        than 1, so we pop 1 2 3 whose next greater element should be 6
    */

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }

        return findNums;
    }
}