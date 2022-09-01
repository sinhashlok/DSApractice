package DSApractice.DP.Easy;

public class Get_Maximum_in_Generated_Array_1646 {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = arr[1];

        for (int i = 2; i <= n; i++) {
            arr[i] = (i % 2 == 0) ? arr[i/2] : (arr[i / 2] + arr[i / 2 + 1]);
            max = Math.max(arr[i], max);
        }

        return max;
    }
}