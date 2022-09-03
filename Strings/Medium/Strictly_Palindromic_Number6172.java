package DSApractice.Strings.Medium;

public class Strictly_Palindromic_Number6172 {

    public boolean isStrictlyPalindromic(int n) {
        if (n == 4) {
            return false;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 2; i <= n - 2; i++) {
            str.append(convert(n, i));

            if (!isPalindrome(str.toString())) {
                return false;
            }
            str.setLength(0);
        }

        return true;
    }

    private StringBuilder convert(int n, int i) {
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            str.append(n % i);
            n /= i;
        }

        return str;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (!(s.charAt(l) == s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}