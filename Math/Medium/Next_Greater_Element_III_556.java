package DSApractice.Math.Medium;

import java.util.Arrays;

public class Next_Greater_Element_III_556 {

    /*
    * 1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
    * 2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
    * 3. For other cases, we need to process the number from rightmost side.
    *   (why? because we need to find the smallest of all greater numbers)
    *
    * Algorithm -
    * I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller
    *       than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because
    *       4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.
    * II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’.
    *       For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
    * III) Swap the above found two digits, we get 536974 in above example.
    * IV) Now sort all digits from position next to ‘d’ to the end of number.
    *       The number that we get after sorting is the output. For above example, we sort digits in bold 536974.
    *       We get “536479” which is the next greater number for input 534976.
    */
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        int i = arr.length - 2;
        // his loop breaks when a smaller number exists left of a larger number
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        Arrays.sort(arr, i + 1, arr.length);

        long val = Long.parseLong(new String(arr));
        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}