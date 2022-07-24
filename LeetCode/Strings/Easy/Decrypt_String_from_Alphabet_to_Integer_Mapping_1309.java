// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

package DSApractice.LeetCode.Strings.Easy;

public class Decrypt_String_from_Alphabet_to_Integer_Mapping_1309 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }

    static String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <n;) {
            if (i < n - 2 && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));  // gives the ASCII value of the character
                ans.append((char) (num + 96));
                i += 3;
            } else {
                ans.append((char) (97 + s.charAt(i) - '1'));
                i += 1;
            }
        }

        return ans.toString();
    }
}