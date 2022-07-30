// https://leetcode.com/problems/remove-outermost-parentheses/

package DSApractice.LeetCode.Stack.Easy;

public class Remove_Outermost_Parentheses_1021 {

        // My approach
    public String removeOuterParenthesesMY(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0, count = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                if (count == 0) {
                }
                else {
                    str.append("(");
                }

                count += 1;
            }
            else {
                if (count == 1) {
                }
                else {
                    str.append(")");
                }

                count -= 1;
            }

            i++;
        }

        return str.toString();
    }

        // shorter form of above code
    public String removeOuterParenthesesLeet(String s) {
        StringBuilder str = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                str.append(c);
            }
            else if (c == ')' && opened-- > 1) {
                str.append(c);
            }
        }
        return str.toString();
    }
}