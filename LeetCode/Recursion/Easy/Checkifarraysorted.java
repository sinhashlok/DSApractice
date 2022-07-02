package DSApractice.LeetCode.Recursion.Easy;

public class Checkifarraysorted {
    public static void main(String[] args) {
        int[] arr = {20, 23, 23, 45, 78, 88};

        if (arraySortedOrNot(arr, arr.length))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    static boolean arraySortedOrNot(int[] arr, int n) {
            // base case
        if (n == 1 || n == 0)
            return true;

        // check if present index and index previous to it are in correct order
        // and rest of the array is also sorted
        // if true then return true else return false
        return arr[n - 1] >= arr[n - 2] && arraySortedOrNot(arr, n - 1);
    }
}
