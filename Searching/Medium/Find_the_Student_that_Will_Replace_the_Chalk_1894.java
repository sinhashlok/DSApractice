package DSApractice.Searching.Medium;

public class Find_the_Student_that_Will_Replace_the_Chalk_1894 {

    public int chalkReplacer(int[] chalk, int k) {
        long[] arr = new long[chalk.length];
        arr[0] = chalk[0];
        long x = k;

        for (int i = 1; i < chalk.length; i++) {
            arr[i] += chalk[i] + arr[i - 1];
        }

        if (x >= arr[arr.length - 1]) {
            x %= arr[arr.length - 1];
        }
        if (x == 0) {
            return 0;
        }

        return binSeach(arr, x);
    }

    private int binSeach(long[] arr, long x) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] == x) {
                return m + 1;
            }

            if (arr[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}