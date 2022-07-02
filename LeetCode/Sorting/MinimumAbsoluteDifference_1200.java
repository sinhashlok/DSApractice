/* Counting sort is used




Algorithm

1. Find the minimum value (minElement) and maximum value (maxElement) in arr.

2. Initialize the auxiliary array line of size maxElement - minElement + 1, and set shift equal to -minElement.
    his means the smallest element in arr will map to index 0 in line, and the largest element will map to the last index in line.

3. Iterate over arr, and for each element value, increment the value at the index value + shift by 1.

4. Traverse the line array and check the value at every index (curr):
    - If line[curr] equals 0, this means the corresponding value is not in arr, so continue on to the next index.
    - If line[curr] equals 1, this means the corresponding value curr - shift is in arr, so we go to step 5.

5. Compare the absolute difference currPairDiff of the pair {prev - shift, curr - shift} with minPairDiff.
    - If currPairDiff is greater than minPairDiff, continue.
    - If currPairDiff equals minPairDiff, add this pair to the answer list.
    - If currPairDiff is less than minPairDiff, discard all elements in answer list, add this pair to the list and update minPairDiff = currPairDiff.
      Let prev = curr and repeat step 4 for the next element in line.

6. After traversing all elements in arr, the answer list will contain all pairs with the minimum absolute difference. Return the answer list.
*/

package DSApractice.LeetCode.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_1200 {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};

        List<List<Integer>> list = minimumAbsDifference(arr);

        for (List<Integer> integers : list)
            System.out.println( "[" + integers.get(0) + " " + integers.get(1) + "]");
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Initialize the auxiliary array `line`.
        // Keep a record of the minimum element and the maximum element - to get the size of aux array
        int minElement = arr[0];
        int maxElement = arr[0];
        for (int num : arr)
        {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }

        int shift = -minElement;
        int[] line = new int[maxElement - minElement + 1];
        List<List<Integer>> answer = new ArrayList<>();

        // For each integer `num` in `arr`, we increment line[num + shift] by 1.
        for (int num : arr)
            line[num + shift] = 1;

        // Start from the index representing the minimum integer, initialize the absolute difference `min_pair_diff` as a huge value such as
        // `max_element - min_element` in order not to miss the absolute difference of the first pair.
        int minPairDiff = maxElement - minElement;
        int prev = 0;

        // Iterate over the array `line` and check if line[curr] holds the occurrence of an input integer.
        for (int curr = 1; curr <= maxElement + shift; ++curr)
        {
            // If line[curr] == 0, meaning there is no occurrence of the integer (curr - shift) held by this index, we will move on to the next index.
            if (line[curr] == 0)
                continue;

            // If the difference (curr - prev) equals `minPairDiff`, we add this pair
            // {prev - shift, curr - shift} to the answer list. Otherwise, if the difference
            // (curr - prev) is smaller than `minPairDiff`, we empty the answer list and add
            // the pair {curr - shift, prev - shift} to the answre list and update the `minPairDiff`
            if (curr - prev == minPairDiff)
                answer.add(Arrays.asList(prev - shift, curr - shift));
            else if (curr - prev < minPairDiff)
            {
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
