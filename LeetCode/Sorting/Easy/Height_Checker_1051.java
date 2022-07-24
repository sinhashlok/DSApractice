// https://leetcode.com/problems/height-checker/

package DSApractice.LeetCode.Sorting.Easy;

public class Height_Checker_1051 {

    public int heightChecker(int[] arr) {
        // below code is faster than,
        // creating a new array, cloning the current array and sorting the new array,
        // and comparing the two

        int[] count = new int[101]; // constraint
        for (int j : arr) { // increment the position, to keep track of how many elements are there
            count[j]++;
        }

        for(int i = 1; i < 101; i++) {  // how many numbers are smaller than the current element
            count[i] = count[i - 1] + count[i];
        }

        int[] output=new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != output[i]) {
                index++;
            }
        }

        return index;
    }

}