// https://leetcode.com/problems/sort-colors/

package DSApractice.LeetCode.Sorting.Medium;

public class Sort_Colors_75 {

    public void sortColors(int[] nums) {
        int zero = 0, one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // find number of 0
                zero += 1;
            }
            else if (nums[i] == 1) {    // find number of 1
                one += 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while(zero != 0) {  // place 0
                nums[i] = 0;
                zero -= 1;
                i += 1;
            }

            while (one != 0) {  // place 1
                nums[i] = 1;
                one -= 1;
                i += 1;
            }

            if (i != nums.length)// rest become 2
                nums[i] = 2;
        }
    }
}