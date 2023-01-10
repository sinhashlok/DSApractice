package DSApractice.Searching.Medium;

public class Find_the_Smallest_Divisor_Given_a_Threshold_1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int r = Integer.MIN_VALUE;

        for (int i : nums) {
            r = Math.max(r, i);
        }

        if (nums.length == threshold) {
            return r;
        }

        int l = 1, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;

            int sum = 0;
            for (int i : nums) {
                sum += (int)(i % m == 0 ? i / m : i / m + 1);
            }

            if (sum == threshold) {
                r = m;
            } else if (sum < threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}