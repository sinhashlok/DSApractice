// https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

package DSApractice.Queue.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_First_K_elements_of_Queue_GFG {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while (k != 0) {
            stack.push(q.peek());
            q.remove();
            k--;
        }

        // add first k element form queue to stack,
        // so that when we add it in the new queue they are reversed
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }

        while (!q.isEmpty()) {
            queue.add(q.peek());
            q.remove();
        }

        return queue;
    }
}