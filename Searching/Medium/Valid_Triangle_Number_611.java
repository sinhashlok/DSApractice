package DSApractice.Searching.Medium;

import java.util.Arrays;

public class Valid_Triangle_Number_611 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            /*
            * there will exist a right limit on the value of index kk, such that the elements satisfy
            * nums[k] > nums[i] + nums[j]nums[k]>nums[i]+nums[j]. Any elements beyond this value of kk won't
            * satisfy this inequality as well, which is obvious.
            * */
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
    private int binarySearch(int nums[], int l, int r, int sum) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= sum)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public int triangleNumberLeet(int[] nums) {
        int count = 0;
        Arrays.sort(nums);


        /*
        * We can find this right limit by simply traversing the index k's values starting from the
        * index k=j+1 for a pair (i, j) chosen and stopping at the first value of k not satisfying the above inequality.
        * Again, the count of elements nums[k] satisfying nums[i] + nums[j] > nums[k]
        * for the pair of indices (i, j) chosen is given by k - j - 1 as discussed in the last approach.
        * */

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;

            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }

                count += k - j - 1;
            }
        }
        
        return count;
    }
}