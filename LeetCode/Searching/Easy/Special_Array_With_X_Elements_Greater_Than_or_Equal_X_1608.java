package DSApractice.LeetCode.Searching.Easy;

public class Special_Array_With_X_Elements_Greater_Than_or_Equal_X_1608 {

    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x+1];

        // keeps track of how many elements are greater than the index
        for(int elem : nums) {
            if (elem >= x) {
                counts[x]++;
            }
            else {
                counts[elem]++;
            }
        }

        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];

            if(res == i) { // when index matches number of elements -> result
                return i;
            }
        }

        return -1;
    }
}