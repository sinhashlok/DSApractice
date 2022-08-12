package DSApractice.Math.Medium;

public class The_kth_Factor_of_n_1492 {

    public int kthFactor(int n, int k) {
        if (k == 1) {
            return 1;
        }

        if (isPrime(n)) {   // if number is prime - no need to keep checking for factors
            if (k == 2) {
                return n;
            } else {
                return -1;
            }
        }

        return factor(n, k);
    }

    public int factor(int n, int k) {
        for(int i = 1; i < Math.sqrt(n); ++i) {
            if(n % i== 0 && --k == 0) {
                return i;
            }
        }

        for(int i = (int) Math.sqrt(n); i >= 1; --i) {
            if(n % (n/i) == 0 && --k == 0) {
                return n/i;
            }
        }

        return -1;
    }

    public boolean isPrime(int n) {
        if (n == 1) return false;
        else if (n == 2 || n == 3) return true;
        else if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}