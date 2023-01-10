package DSApractice.Searching.Medium;

public class Sum_of_Square_Numbers_633 {

    // using sqrt
    public boolean judgeSquareSumSqrt(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);

            if (b == (int) b) {
                return true;
            }
        }

        return false;
    }

    // binary search
    public boolean judgeSquareSumbin(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);

            if (binary_search(0, b, b)) {
                return true;
            }
        }

        return false;
    }
    private boolean binary_search(long s, long e, int n) {
        if (s > e) {
            return false;
        }

        long mid = s + (e - s) / 2;

        if (mid * mid == n) {
            return true;
        }
        if (mid * mid > n) {
            return binary_search(s, mid - 1, n);
        }

        return binary_search(mid + 1, e, n);
    }
}