package DSApractice.Heap.Medium;

import java.util.PriorityQueue;

public class Longest_Uploaded_Prefix_6197 {

    private int l = 0;
    private PriorityQueue<Integer> heap;
    public void LUPrefix(int n) {
        heap = new PriorityQueue<>();
    }

    public void upload(int video) {
        heap.offer(video);

        while (!heap.isEmpty() && (heap.peek() == l + 1)) {
            l = heap.poll();
        }
    }

    public int longest() {
        return l;
    }
}