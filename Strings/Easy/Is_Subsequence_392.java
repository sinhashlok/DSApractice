package DSApractice.Strings.Easy;

public class Is_Subsequence_392 {

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;

        for (int i = 0; i < m && j < n; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }

        return (j == n);
    }
}