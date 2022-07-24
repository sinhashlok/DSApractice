// https://leetcode.com/problems/shuffle-string/

package DSApractice.LeetCode.Strings.Easy;

public class Shuffle_String_1528 {

    static String restoreString(String s, int[] indices) {
        StringBuilder str = new StringBuilder();
        str.append(s);

        for (int i = 0; i < s.length(); i++) {
            str.setCharAt(indices[i], s.charAt(i));
        }

        return str.toString();
    }

}