// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

package DSApractice.LeetCode.Searching.Easy;

public class Array_With_X_Elements_Greater_Than_or_Equal_X_1608 {

    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] count = new int[x + 1];

        // keeps track of how many elements are greater than the index
        for (int ele : nums) {
            if (ele >= x) {
                count[x]++;
            } else {
                count[ele]++;
            }
        }

        int res = 0;
        for (int i = count.length - 1; i > 0; i--) {
            res += count[i];
            if (res == i) { //when index matches number of elements greater -> result
                return i;
            }
        }

        return -1;
    }
}
