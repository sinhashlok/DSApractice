package DSApractice.Heap.Easy;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream_703 {

    private int k;
    private PriorityQueue<Integer> heap;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int i : nums) {
            heap.offer(i);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}