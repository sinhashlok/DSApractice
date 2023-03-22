package DSApractice.Stack.Easy;

import java.util.Stack;

public class Valid_Parentheses_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 1) {
            return false;
        }

        int i = 0;
        while (i != s.length()) {
            char ch = s.charAt(i);

            if ((ch == '{') || (ch == '(') || (ch == '[')) {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (!matching(stack.peek(), ch)) {
                    return false;
                }
                stack.pop();
            }

            i += 1;
        }

        return stack.isEmpty();
    }

    public boolean matching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
    }
}