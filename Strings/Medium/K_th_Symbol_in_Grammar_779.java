package DSApractice.Strings.Medium;

public class K_th_Symbol_in_Grammar_779 {

    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) { // base case
            return 0;
        }

        int pow = (int)Math.pow(2, n - 2);   // calculating half size

        if (k > pow) { // because for every row 2nd half is complement of 1st half
            return 1 - kthGrammar(n, k - pow);
        } else {       // if k is in 1st half then it is same as what is above it
            return kthGrammar( n-1 , k);
        }
    }
}