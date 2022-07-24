// https://practice.geeksforgeeks.org/problems/last-non-zero-digit-in-factorial5846/1?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

public class Last_non_zero_digit_in_factorial_GFG {
    public static void main(String[] args) {
        System.out.println(lastNon0Digit(99));
    }

    static int lastNon0Digit(int N) {
        // Code here
        long[] arr = new long[N];
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] % 10 == 0) {
                arr[i - 1] /= 10;
            }
            arr[i] = arr[i - 1] * (i + 1);
        }

        long res = arr[arr.length - 1];

        int i = 0;
        while (i == 0) {
            if (res % 10 == 0) {
                res /= 10;
            }
            i = (int)(res % 10);
        }

        return i;
    }
}