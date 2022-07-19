// https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

package DSApractice.LeetCode.Strings.Easy;

public class Number_of_Strings_That_Appear_as_Substrings_in_Word_1967 {

    static int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String s : patterns) {
            if (word.contains(s)) {
                count ++;
            }
        }

        return count;
    }

}