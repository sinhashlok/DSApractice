package DSApractice.Searching.Medium;

import java.util.Arrays;

public class _Maximum_Number_of_Removable_Characters_1898 {

    /*
     * How Binary search?
     * - l => the lower limit (0 at first), while r => the upper limit (the length of the removable array)
     * - Each time, we find the middle number (which is an attempt to remove that number of letters from the string)
     * -- use an array of characters and replace those letters removed with the '/' symbol
     * */
    public int maximumRemovals(String s, String p, int[] removable) {
        // make letters into array of characters
        char[] letters = s.toCharArray();

        // boundaries
        int l = 0, r = removable.length, m = 0;
        // binary search
        while (l <= r) {
            // m represents how many letters we remove this round.
            m = l + (r - l) / 2;

            // Remove those letters
            for (int i = 0; i < m; i++) {
                letters[removable[i]] = '/';
            }

            // we perform a simple check to see if p is still a subsequence of it. If it is, change the lower boundary.
            if (check(letters, p)) {
                l = m + 1;
            } else {
                // Otherwise, we replace back all the letters that we had removed.
                // Then, we change the upper boundary.
                for (int i = 0; i < m; i++) {
                    letters[removable[i]] = s.charAt(removable[i]);
                }
                r = m - 1;
            }
        }

        return r;
    }


    /*
     * we use two-pointers
     * 1. keep track of which char we are looking at now in the char array
     * 2. another to keep track of which char we are looking at in p
     * # If the character wasn't removed and the characters are equal, we increment both pointers.
     * # else only increment the first pointer pointing to the array of characters.
     * */
    public boolean check(char[] letters, String p) {
        int i = 0, j = 0;
        while (i < letters.length && j < p.length()) {
            char curr = letters[i];
            char curr2 = p.charAt(j);
            if (curr != '/' && curr == curr2) {
                j++;
            }

            i++;
        }

        // If i2 == p.length(), it means that we had managed to match all the characters in String p
        if (j == p.length()) {
            return true;
        }

        return false;
    }
}