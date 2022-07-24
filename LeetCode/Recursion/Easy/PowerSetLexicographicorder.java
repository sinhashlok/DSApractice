/* https://www.geeksforgeeks.org/powet-set-lexicographic-order/
    Input : abc
    Output : a ab abc ac b bc c
*/

package DSApractice.LeetCode.Recursion.Easy;

import java.util.Arrays;

public class PowerSetLexicographicorder {
    public static void main(String[] args) {
        powerSetRecur1("", "abc");
    }

    static void powerSetRecur1(String s, String str) {
        if (str.length() == 0) {
            System.out.print(s + " ");
            return;
        }

        if (s.length() != 0) {
            System.out.print(s + " ");
        }

        for (int i = 0; i < str.length(); i++) {
            powerSetRecur1(s + str.charAt(i), str.substring(i + 1));
        }
    }
}