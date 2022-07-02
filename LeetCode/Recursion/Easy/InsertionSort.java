package DSApractice.LeetCode.Recursion.Easy;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        insertion(arr, arr.length);
        for (int n : arr)
            System.out.print(n + " ");
    }

    static void insertion(int[] arr, int n) {
        if (n <= 1)
            return;

        insertion(arr, n-1);

        int last = arr[n-1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}
