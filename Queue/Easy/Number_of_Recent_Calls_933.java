package DSApractice.Queue.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Recent_Calls_933 {

    // My approach - use Queue
    Queue<Integer> q;
    public void RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        if (t >= 3000) {
            while (q.peek() != null && q.peek() < t - 3000) {
                q.remove();
            }
        }

        return q.size();
    }


    // LeetCode - use LinkedList (much faster)
    LinkedList<Integer> slideWindow;
    public void RecentCounterLeet() {
        this.slideWindow = new LinkedList<Integer>();
    }

    public int pingLeet(int t) {
        this.slideWindow.addLast(t);

        while (this.slideWindow.getFirst() < t - 3000) {
            this.slideWindow.removeFirst();
        }

        return this.slideWindow.size();
    }
}