package DSApractice.Strings.Medium;

import java.util.Arrays;

public class Permutation_in_String_567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);

        int l = 0, r = s1.length() - 1;
        while (r < s2.length()) {
            String s = s2.substring(l, r + 1);
            char[] ch2 = s.toCharArray();
            Arrays.sort(ch2);

            if (helper(ch1, ch2)) {
                return true;
            }

            l++;
            r++;
        }

        return false;
    }

    private boolean helper(char[] ch1, char[] ch2) {
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }

        return true;
    }
}