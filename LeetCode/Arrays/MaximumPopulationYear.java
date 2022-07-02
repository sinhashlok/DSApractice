package DSApractice.LeetCode.Arrays-practice.LeetCode.Arrays;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        int[][] logs = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };

        System.out.println(maxpop(logs));
    }

    static int maxpop(int[][] logs) {
        int[] arr = new int[101];

        for (int[] log : logs) {
            arr[log[0] - 1950]++;
            arr[log[1] - 1950]--;
        }

        int maxi = arr[0], ind = 0;
        for (int i = 1; i < 101; i++)
        {
            arr[i] += arr[i-1];
            if (maxi < arr[i])
            {
                maxi = arr[i];
                ind = i;
            }
        }

        return 1950 + ind;
    }
}
