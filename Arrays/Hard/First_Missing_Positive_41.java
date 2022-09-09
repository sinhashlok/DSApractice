package DSApractice.Arrays.Hard;

public class First_Missing_Positive_41 {

    public int firstMissingPositive(int[] nums) {
        boolean[] arr = new boolean[nums.length];

        // we try to find numbers between 0 and nums.length
        // cause the first missing positive integer has to be from here
        /*
        * say the array is sorted from first 0 to n - 1 numbers, then
        * the first missing will be n
        */
        // How to achieve?
        // we create a boolean array of size nums.length, and mark the indices between
        // 0 to n-1 as false;
        for (int i : nums) {
            if (i <= 0 || i > nums.length) {
                continue;
            }

            arr[i - 1] = true;
        }

        int i = 0;
        for (; i < arr.length; i++) {
            // if the element is false, means it is first missing positive integer form the nums
            if (!arr[i]) {
                return i + 1;
            }
        }

        // if all elements from 0 to n-1 were already there in nums
        // then first missing positive integer is n
        return i + 1;
    }
}