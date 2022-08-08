// https://leetcode.com/problems/frequency-of-the-most-frequent-element/

package DSApractice.Searching.Medium;

import java.util.Arrays;

public class Frequency_of_the_Most_Frequent_Element_1838 {

    /*Sort and Sliding window*/
    public int maxFrequencySortSliding(int[] nums, int k) {
        /*
        * Here we point the r - to the element to which we want all element in the pointer space to be
        * Sum - keeps track of the total sum  between the pointers
        * windowLen - number of elements in the pointer area
        * sum + k < is the maximum sum possible if we use the k, to increase all the numbers, in pointer to make them
        *   all equal to rth number
        *
        * IDEA: (sum + k < nums[r](rth number) * windowLen)
        * If sum + k< nums[r](rth number) * windowLen ===> even after using all k, we are unable to make all numbers
        *   between the pointer search equal to rth number, so left move l one place right
        *
        * res - stores the max windowLen
        */

        int res = 1, l = 0, r = 0, windowLen = 0;
        long sum = 0;
        Arrays.sort(nums);

        for (r = 0; r < nums.length; ++r) {
            sum += nums[r];
            windowLen++;

            while (sum + k < (long)nums[r] * windowLen) {
                sum -= nums[l];
                l += 1;
                windowLen--;
            }
            res = Math.max(res, windowLen);
        }
        return res;
    }


    // above approach using binary search
    // VERY slow
    public long[] preSum;
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, count(nums, k, i));
        }

        return ans;
    }

    public long getSum(int l, int r) {   // left and right inclusive
        return preSum[r + 1] - preSum[l];
    }

    // Count frequency of `nums[index]`,
    // if we make other elements equal to `nums[index]`
    public int count(int[] nums, int k, int index) {
        int l = 0, r = index, res = index;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // get sum of(nums[mid], nums[mid + 1]...nums[index - 1])
            long s = getSum(mid, index - 1);

            // Found an answer -> Try to find a better answer in the left side
            if (s + k >= (long)(index - mid) * nums[index]) {   // this condition is the same one as using in sliding window approach
                // save the best answer in res
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index - res + 1;
    }
}