package DSApractice.Searching.Hard;

public class Maximum_Number_of_Robots_Within_Budget_6143 {
    public static void main(String[] args) {
        int[] arr1 = {19,63,21,8,5,46,56,45,54,30,92,63,31,71,87,94,67,8,19,89,79,25};
        int[] arr2 = {91,92,39,89,62,81,33,99,28,99,86,19,5,6,19,94,65,86,17,10,8,42};

        System.out.print(maximumRobots(arr1, arr2, 85));
    }

    static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int l = 0, r = 0, max = 0, sum = 0;
        int res = 0;

        while (r < chargeTimes.length) {
            // max charge Time
            max = getMax(chargeTimes, l, r);

            // sum
            sum += runningCosts[r];

            int k = r - l + 1;

//            long F = max + ((long) k * sum);
            if (max + ((long) k * sum) <= budget) {
                res = Math.max(k, res);
                r++;
            } else {
                sum -= runningCosts[l];
                l++;
                r++;
            }
        }

        return res;
    }

     static int getMax(int[] arr, int l, int r) {
        int max = 0;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}