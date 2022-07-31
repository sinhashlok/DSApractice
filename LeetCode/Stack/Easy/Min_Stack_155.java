package DSApractice.LeetCode.Stack.Easy;

import java.util.Stack;

public class Min_Stack_155 {

    public class MinStack {
        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            int peek = stack.pop();
            if (peek == min){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}