// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

package DSApractice.LeetCode.Strings.Easy;

public class Check_If_Two_String_Arrays_are_Equivalent_1662 {

    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (String i : word1) {
            str1.append(i);
        }
        for (String i : word2) {
            str2.append(i);
        }

        return str1.toString().equals(str2.toString());
    }

}