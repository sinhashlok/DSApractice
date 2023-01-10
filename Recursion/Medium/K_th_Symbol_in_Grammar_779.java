package DSApractice.Recursion.Medium;

public class K_th_Symbol_in_Grammar_779 {

    public int kthGrammar(int n, int k) {
        return helper(n, k - 1);
    }

    private int helper(int n, int k) {
        if (k == 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        }

        if (k % 2 == 0) {
            return helper(n, k / 2);
        } else {
            return helper(n, k / 2) == 0 ? 1 : 0;
        }
    }
}