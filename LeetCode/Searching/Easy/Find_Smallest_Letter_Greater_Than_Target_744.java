// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

package DSApractice.LeetCode.Searching.Easy;

public class Find_Smallest_Letter_Greater_Than_Target_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length, m = 0;

        while (l < r) {
            m = l+ (r - l) / 2;

            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return letters[l % letters.length];
    }

}
