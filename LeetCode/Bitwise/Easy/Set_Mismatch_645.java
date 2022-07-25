// https://leetcode.com/problems/set-mismatch/

package DSApractice.LeetCode.Bitwise.Easy;

public class Set_Mismatch_645 {

        // counting sort way
    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return new int[]{arr[index], index + 1};
            }
        }

        return new int[] {-1, -1};
    }
}