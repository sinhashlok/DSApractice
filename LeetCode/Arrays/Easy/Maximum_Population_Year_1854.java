// https://leetcode.com/problems/maximum-population-year/

package DSApractice.LeetCode.Arrays.Easy;

public class Maximum_Population_Year_1854 {

    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];

        for (int i = 0; i < logs.length; i++) {
            arr[logs[i][0] - 1950] ++;
            arr[logs[i][1] - 1950] --;
        }

        int maxi = arr[0], ind = 0;
        for (int i = 1; i < 101; i++) {
            arr[i] += arr[i-1];
            if (maxi < arr[i]) {
                maxi = arr[i];
                ind = i;
            }
        }

        return 1950 + ind;
    }
}