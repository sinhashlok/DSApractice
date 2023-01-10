package DSApractice.Recursion.Medium;

public class Count_Good_Numbers_1922 {

    /*
    * n is even, the solution is (4 * 5) ^ (n / 2)
    *   if odd, (4 * 5) ^ (n / 2) * 5.
    * */
    public int countGoodNumbers(long n) {
        long mod = (long)Math.pow(10,9);
        mod += 7;

        long ans = (n % 2 == 0) ? 1 : 5;
        for (long i = n / 2, x = 4 * 5; i > 0; i /= 2, x = (x * x) %  mod) {
            if (i % 2 != 0) {
                ans = ans * x % mod;
            }
        }

        return (int)ans;
    }
}