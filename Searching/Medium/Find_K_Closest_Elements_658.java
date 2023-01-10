package DSApractice.Searching.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_K_Closest_Elements_658 {

    // LeetCode
    public List<Integer> findClosestElementsLeet(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - 1;

        // we use two pointers to rule out more than k elements
        // and only keep k the closest elements
        while (h - l >= k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[h] - x)) {
                l++;
            } else {
                h--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= h; i++) {
            result.add(arr[i]);
        }
        return result;
    }


    // My approach
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = binSearch(arr, x);

        // check if x exists in the array or not
        if (arr[pos] != x && pos != 0) {
            pos--;
        }

        int front = pos + 1, back = pos;
        List<Integer> list = new ArrayList<>();

        while (k != 0) {
            int a = 0;
            if (back >= 0) {
                a = Math.abs(arr[back] - x);
            } else {
                a = Integer.MAX_VALUE;
            }

            int b = 0;
            if (front <= arr.length - 1) {
                b = Math.abs(arr[front] - x);
            } else {
                b = Integer.MAX_VALUE;
            }

            if (a < b) {
                list.add(arr[back]);
                back--;
            } else if (b < a) {
                list.add(arr[front]);
                front++;
            } else {
                if (arr[back] < arr[front]) {
                    list.add(arr[back]);
                    back--;
                } else {
                    list.add(arr[front]);
                    front++;
                }
            }

            k--;
        }

        Collections.sort(list);
        return list;
    }
    private int binSearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;

            if (arr[m] == x) {
                return m;
            }

            if (arr[m] > x) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}