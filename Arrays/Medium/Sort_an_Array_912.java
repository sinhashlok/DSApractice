package DSApractice.Arrays.Medium;

public class Sort_an_Array_912 {

    // Heap Sort
    public int[] sortArrayHeap(int[] nums) {
        buildHeap(nums, nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }

        return nums;
    }
    private void buildHeap(int[] nums, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }
    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            heapify(nums, n, largest);
        }
    }

    // Quick Sort - V.V. slow
    public int[] sortArrayQuick(int[] nums) {
        qSort(nums, 0, nums.length - 1);

        return nums;
    }
    private void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);

            qSort(nums, l, p);
            qSort(nums, p + 1, r);
        }
    }
    private int partition(int[] nums, int l, int r) {
        int i = l - 1, j = r + 1;
        int p = nums[l];

        while (true) {
            do {
                i++;
            } while (nums[i] < p);
            do {
                j--;
            } while (nums[j] > p);

            if (i >= j) {
                return j;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}