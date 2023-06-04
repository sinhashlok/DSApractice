package DSApractice.Arrays.Medium;

import java.util.*;

public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequentQucikSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[][] arr = new int[2][map.size()];
        int index = 0;
        for (Integer i : map.keySet()) {
            arr[0][index] = i;
            arr[1][index] = map.get(i);
            index++;
        }

        qucikSelect(arr, map.size() - k);

        index = arr[1].length - 1;
        int[] res = new int[k];
        while (k != 0) {
            res[k - 1] = arr[0][index];
            k--;
            index--;
        }

        return res;
    }

    private void qucikSelect(int[][] arr, int k) {
        int l = 0, r = arr[1].length - 1;

        while (l <= r) {
            int p = partition(arr, l, r);

            if (p == k - 1) {
                return;
            } else if (p > k - 1) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
    }

    private int partition(int[][] arr, int l, int r) {
        int pivot = arr[1][r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[1][j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, r);

        return i + 1;
    }

    private void swap(int[][] arr, int i, int j) {
        int temp0 = arr[0][j];
        arr[0][j] = arr[0][i];
        arr[0][i] = temp0;

        int temp1 = arr[1][j];
        arr[1][j] = arr[1][i];
        arr[1][i] = temp1;
    }

    // Naive approach
    public int[] topKFrequentPQ(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // add all elements and their frequency in map
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Make a max-heap PQ and add frequencies from map in PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int x = pq.poll(), num = 0;

            // find an element corresponding to x (=pq.poll())
            // get the corresponding number, and remove it from map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == x) {
                    num = entry.getKey();
                    map.remove(num);
                    break;
                }
            }

            res[i] = num;
        }

        return res;
    }
}