// https://leetcode.com/problems/intersection-of-two-arrays-ii/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_II_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int x : nums1) {   // keeps track of every element and the number of its occurrence
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : nums2) {
            if (map.containsKey(x)) {
                if (map.get(x) == 0) {
                    continue;
                } else {
                    map.put(x, map.getOrDefault(x, 0) - 1);
                    list.add(x);
                }
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

}
