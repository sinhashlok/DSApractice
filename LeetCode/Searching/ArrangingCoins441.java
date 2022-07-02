package DSApractice.LeetCode.Searching;

public class ArrangingCoins441 {
    public static void main(String[] args) {
        int n = 1804289383;
        System.out.println(arrangeCoins(n));
    }

    static int arrangeCoins(int n) {
        int l = 1, h = n, m;
        long i;

        while (l <= h)
        {
            m = l + (h - l) / 2;
            i = ((long) m * (m + 1)) / 2;

            if (i == n)
                return m;
            else if (i < n)
                l = m + 1;
            else
                h = m - 1;
        }

        return h;
    }
}
