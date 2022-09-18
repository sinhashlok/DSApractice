package DSApractice.Strings.Easy;

import java.util.HashSet;
import java.util.Set;

public class Longest_Nice_Substring_1763 {

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        // convert string to character array
        char[] ch = s.toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c : ch) {
            set.add(c);
        }

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];

            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
                continue;
            }

            String s1 = longestNiceSubstring(s.substring(0 , i));
            String s2 = longestNiceSubstring(s.substring(i + 1));

            return s1.length() >= s2.length() ? s1 : s2;
        }

        return s;
    }
}