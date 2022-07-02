/* https://www.geeksforgeeks.org/sum-triangle-from-array/
    Given an array of integers, print a sum triangle from it such that the first level has all array elements.
    From then, at each level number of elements is one less than the previous level and elements at the level is
    be the Sum of consecutive two elements in the previous level.

    Input : A = {1, 2, 3, 4, 5}
    Output : [48]
             [20, 28]
             [8, 12, 16]
             [3, 5, 7, 9]
             [1, 2, 3, 4, 5]
*/

package DSApractice.LeetCode.Recursion.Easy;

import java.util.Arrays;

public class Sumtrianglefromarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        // My APPROACH
//        myApproach(arr, arr.length - 1);
//        for (int n : arr)
//            System.out.print(n + " ");

        betterApproach(arr);
    }

    static void myApproach(int[] arr, int h) {
        if (h == 0)
            return;

        for (int i = 0; i < h; i++)
            arr[i] = arr[i] + arr[i + 1];
        h -= 1;
        myApproach(arr, h);

        for (int i = 0; i <= h; i++)
            System.out.print(arr[i] + " ");

        for (int i = h; i >= 0; i--)
            arr[i] = arr[i] - arr[i + 1];

        System.out.println();
    }

    static void betterApproach(int[] arr) {
        // Base condition
        if (arr.length < 1)
            return;

        // Creating new array which contains the Sum of consecutive elements in
        // the array passes as parameter.
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++)
            temp[i] = arr[i] + arr[i + 1];

        // Make a recursive call and pass the newly created array
        betterApproach((temp));

        // Print current array in the end so that smaller arrays are printed first
        System.out.println(Arrays.toString(arr));
    }
}
