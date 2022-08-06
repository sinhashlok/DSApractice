// https://leetcode.com/problems/is-subsequence/

package DSApractice.Searching.Easy;

public class Is_Subsequence_392 {

    public boolean isSubsequence(String s, String t) {
        int n = s.length(),m=t.length();
        int j = 0;
        // For index of s (or subsequence

        // Traverse s and t, and compare current character of s with first unmatched char
        // of t, if matched then move ahead in s
        for (int i = 0; i < m && j < n; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }

        // If all characters of s were found in t
        return (j == n);
    }
}