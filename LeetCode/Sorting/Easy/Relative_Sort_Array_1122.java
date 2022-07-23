// https://leetcode.com/problems/relative-sort-array/

package DSApractice.LeetCode.Sorting.Easy;

public class Relative_Sort_Array_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];    // temp array - constraint -> 1000
        // track of all elements in arr1, and number of times it occurs
        for (int k : arr1) {
            count[k]++;
        }

        int i = 0, index = 0;
        // sort it according to arr2
        while (i < arr2.length) {
            while (count[arr2[i]] != 0) {
                arr1[index] = arr2[i];
                count[arr2[i]]--;
                index++;
            }
            i++;
        }

        // for the elements that are left, i.e., not present in arr2
        for (int j = 0; j < count.length; j++) {
            while (count[j] != 0) {
                arr1[index] = j;
                count[j]--;
                index++;
            }
        }

        return arr1;
    }

}