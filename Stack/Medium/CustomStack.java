// Design a Stack With Increment Operation 1381
// https://leetcode.com/problems/design-a-stack-with-increment-operation/


package DSApractice.Stack.Medium;

public class CustomStack {

    int[] stack;
    int size = 0;
    int max = 0;

    public CustomStack(int maxSize) {
        max = maxSize;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (size != max) {
            stack[size] = x;
            size += 1;
        }
    }

    public int pop() {
        if (size >= 1) {
            return stack[--size];
        }

        return -1;
    }

    public void increment(int k, int val) {
        k = (k >= max) ? size : k;
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}