package DSApractice.LeetCode.Sorting.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference_1200 {

        // My Approach
    public List<List<Integer>> minimumAbsDifferenceMY(int[] arr) {
        int maxD = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            maxD = Math.min(Math.abs(arr[i] - arr[i - 1]), maxD);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (maxD == Math.abs(arr[i] - arr[i - 1])) {
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return list;
    }

        // LeetCode
    public List<List<Integer>> minimumAbsDifferenceLeet(int[] arr) {
        // Initialize the auxiliary array `line`.
        // Keep a record of the minimum element and the maximum element.
        int minElement = arr[0];
        int maxElement = arr[0];
        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }
        int shift = -minElement;
        int[] line = new int[maxElement - minElement + 1];
        List<List<Integer>> answer = new ArrayList<>();

        // For each integer `num` in `arr`, we increment line[num + shift] by 1.
        for (int num : arr) {
            line[num + shift] = 1;
        }

        // Start from the index representing the minimum integer, initialize the
        // absolute difference `min_pair_diff` as a huge value such as
        // `max_element - min_element` in order not to miss the absolute
        // difference of the first pair.
        int minPairDiff = maxElement - minElement;
        int prev = 0;

        // Iterate over the array `line` and check if line[curr]
        // holds the occurrence of an input integer.
        for (int curr = 1; curr <= maxElement + shift; ++curr) {
            // If line[curr] == 0, meaning there is no occurrence of the integer (curr - shift)
            // held by this index, we will move on to the next index.
            if (line[curr] == 0) {
                continue;
            }

            // If the difference (curr - prev) equals `minPairDiff`, we add this pair
            // {prev - shift, curr - shift} to the answer list. Otherwise, if the difference
            // (curr - prev) is smaller than `minPairDiff`, we empty the answer list and add
            // the pair {curr - shift, prev - shift} to the answre list and update the `minPairDiff`
            if (curr - prev == minPairDiff) {
                answer.add(Arrays.asList(prev - shift, curr - shift));
            } else if (curr - prev < minPairDiff) {
                answer = new ArrayList();
                minPairDiff = curr - prev;
                answer.add(Arrays.asList(prev - shift, curr - shift));
            }

            // Update prev as curr.
            prev = curr;
        }

        return answer;
    }

}