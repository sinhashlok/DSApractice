package DSApractice.Stack.Medium;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {

    public int evalRPN(String[] tokens) {
        // this will store the numbers
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                if (tokens[i].equals("+")) {
                    a += b;
                } else if (tokens[i].equals("-")) {
                    a -= b;
                } else if (tokens[i].equals("*")) {
                    a *= b;
                } else {
                    a /= b;
                }
                stack.push(a);

            } else {
                stack.push(Integer.parseInt(tokens[i]));
                // converts string to Integer, and then adds in stack
            }
        }

        return stack.pop();
    }
}