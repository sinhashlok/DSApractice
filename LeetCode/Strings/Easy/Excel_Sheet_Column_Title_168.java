// https://leetcode.com/problems/excel-sheet-column-title/

package DSApractice.LeetCode.Strings.Easy;

public class Excel_Sheet_Column_Title_168 {

    static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n > 0) {
            n -= 1;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }

}
