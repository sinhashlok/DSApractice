// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

package DSApractice.LeetCode.Bitwise.Easy;

public class Prime_Number_of_Set_Bits_in_Binary_Representation_762 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int n = Integer.bitCount(i);
            if (isPrime(n)) {
                count += 1;
            }
        }

        return count;
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        else if (n == 2 || n == 3) return true;
        else if (n % 2 == 0 || n % 3 == 0) return false;    // check if divisble by 2 or 3

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}