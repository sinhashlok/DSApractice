package DSApractice.Searching.Easy;

import java.util.Arrays;

public class Find_the_Distance_Value_Between_Two_Arrays_1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int j : arr1) {
            boolean flag = false;
            int index = binarySearch(j, arr2);

            int ind = index - 1;
            while ((ind >= 0) && Math.abs(j - arr2[ind]) <= d) {
                count += 1;
                ind -= 1;
                flag = true;
                break;
            }

            if (flag) {
                continue;
            }

            while ((index <= arr2.length - 1) && Math.abs(j - arr2[index]) <= d) {
                count += 1;
                index += 1;
                break;
            }
        }

        return arr1.length - count;
    }

    public int binarySearch(int x, int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] < x) {
                l = m + 1;
            } else if (nums[m] > x) {
                r = m;
            } else {
                return m;
            }
        }

        return l;
    }
}