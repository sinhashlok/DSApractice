// https://leetcode.com/problems/rank-transform-of-an-array/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Rank_Transform_of_an_Array_1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr, arr.length);   // clone array
        Arrays.sort(A);

        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : A) {   // this makes for the rank, the second element stores the rank
            rank.putIfAbsent(x, rank.size() + 1);
        }

        // this will make the new array with rank as elements
        for (int i = 0; i < arr.length; ++i) {
            A[i] = rank.get(arr[i]);
        }

        return A;
    }
}