package DSApractice.Searching.Medium;

public class Find_the_Smallest_Divisor_Given_a_Threshold_1283 {
    public static void main(String[] args) {
        int[] nums = {200,100,14};
        System.out.println(smallestDivisor(nums, 10));
    }

    static int smallestDivisor(int[] nums, int threshold) {
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

//            int sum = 0;
//            for (int i : nums) {
//                sum += (int)(i / m == 0 ? 1 : i / m);
//            }
            int sum = getSum(nums, m);

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

    private static int getSum(int[] nums, int n) {
        int sum = 0;
        for (int i : nums) {
            sum += (int)(i % n == 0 ? i / n : i / n + 1);
        }

        return sum;
    }
}