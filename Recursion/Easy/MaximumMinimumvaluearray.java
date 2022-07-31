/* https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/
    If there is single element, return it.
    Else return minimum of following.
        a) Last Element
        b) Value returned by recursive call for n-1 elements.
*/

package DSApractice.LeetCode.Recursion.Easy;

public class MaximumMinimumvaluearray {
    public static void main(String[] args) {
        int[] arr = {2,4,5,1,3};

        System.out.println(minElement(arr, arr.length));
        System.out.println(maxElement(arr, arr.length));
    }

    static int minElement(int[] arr, int n) {
        if (n == 1)
            return arr[0];

        return Math.min(arr[n - 1], minElement(arr, n - 1));
    }

    static int maxElement(int[] arr, int n) {
        if (n == 1)
            return arr[0];

        return Math.max(arr[n - 1], maxElement(arr, n - 1));
    }
}
