package DSApractice.Stack.Easy;

import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {

    int front = 0;
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public void MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }

        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }

        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}