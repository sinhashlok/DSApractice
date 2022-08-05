// https://leetcode.com/problems/split-array-largest-sum/

package DSApractice.Searching.Hard;

public class Split_Array_Largest_Sum_410 {

    public int splitArray(int[] nums, int m) {
        int start = 0, end = 0;

        for (int i : nums) {
            start = Math.max(start, i); // maximum element -> when m = nums.length
            end += i;   // maximum value -> sum of all values
        }

        // binary Search
        while (start < end) {
            // try for middle as potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in this sub array, make new one
                    // say you add this in new sub array, sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end; // here start == end
    }
}