package DSApractice.Strings.Easy;

public class Valid_Anagram_242 {

    public boolean isAnagram(String s, String t) {
        // if length (no. of characters are not same => false
        if (s.length() != t.length()) {
            return false;
        }

        // 26 alphabets
        int[] freqs = new int[26];
        // increment index corresponding to each char of s
        for (char c: s.toCharArray()) {
            freqs[c -'a']++;
        }

        // decrement index corresponding to each char of s
        for (char c: t.toCharArray()) {
            // if c has more chara, one pos will go negative
            if (--freqs[c -'a'] < 0) {
                return false;
            }
        }


        return true;
    }
}
