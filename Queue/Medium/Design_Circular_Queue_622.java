package DSApractice.Queue.Medium;

public class Design_Circular_Queue_622 {

    private int[] arr;
    int l = 0, r = -1, len = 0;

    public void MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            r = (r + 1) % arr.length;
            arr[r] = value;
            len ++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            l = (l + 1) % arr.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : arr[l];
    }

    public int Rear() {
        return isEmpty() ? -1: arr[r];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == arr.length;
    }
}