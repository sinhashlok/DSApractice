// https://leetcode.com/problems/intersection-of-two-arrays/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.HashSet;

public class Intersection_of_Two_Arrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        for (Integer n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int ind = 0;
        for (int s : set1) {
            output[ind++] = s;
        }

        return output;
    }

}
