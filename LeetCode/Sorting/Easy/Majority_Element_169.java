// https://leetcode.com/problems/majority-element/

package DSApractice.LeetCode.Sorting.Easy;

public class Majority_Element_169 {

    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        for (int x : nums) {
            if (count == 0) {
                candidate = x;
            }

            // if there are more than (n/2) elements
            // then after complete iteration, it will still be there
            // as it will be more than any other
            // so count will be positive for it
            count += (x == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
