// https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/

package DSApractice.LeetCode.Strings.Easy;

public class Reverse_Words_in_a_String_III_557 {

        // My Approach
        static String reverseWordsMY(String s) {
            String[] words = s.split(" ");

            StringBuilder str = new StringBuilder();
            for (String x : words) {
                StringBuilder extra = new StringBuilder();
                extra.append(x).reverse();
                str.append(extra).append(" ");
                extra.setLength(0);
            }

            str.deleteCharAt(str.length() - 1);
            return str.toString();
        }

            // Leetcode approach
        static String reverseWordsLEET(String input) {
            final StringBuilder result = new StringBuilder();
            final StringBuilder word = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ') {
                    word.append(input.charAt(i));
                } else {
                    result.append(word.reverse());
                    result.append(" ");
                    word.setLength(0);
                }
            }

            result.append(word.reverse());
            return result.toString();
        }
}
