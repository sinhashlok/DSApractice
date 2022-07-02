/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

        Input: intervals = [[3,4],[2,3],[1,2]]
        Output: [-1,0,1]
        Explanation: There is no right interval for [3,4].
        The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
        The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
*/
package DSApractice.LeetCode.Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval_436 {
    public static void main(String[] args) {
        int[][] intervals = {
                {3,4},
                {2,3},
                {1,2}
        };

        int[] ans = findRightInterval(intervals);

        for (int x : ans)
            System.out.print(x + " ");
    }

    static int[] findRightInterval(int[][] intervals) {
        // we use key and value pair -> hashmap

        // create a new array to store start index of intervals so that we can sort and binary search in it
        int[] starts = new int[intervals.length];

        // to keep track of index of start elements
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < intervals.length; i++)
        {
            indices.put(intervals[i][0], i);
            starts[i] = intervals[i][0];
        }

        Arrays.sort(starts);

        int[] result = new int[intervals.length];   // ans array
        for (int i = 0; i < intervals.length; i++)
        {
            int index = Arrays.binarySearch(starts, intervals[i][1]);   // finds index of second elements of intervals in starts

            if (index > 0)
                result[i] = indices.get(starts[index]); // find the values of that element, whose key matches to that in starts in indices
            else
            {
                index = - index - 1;
                if (index < intervals.length)
                    result[i] = indices.get(starts[index]);
                else
                    result[i] = -1;
            }
        }

        return result;
    }
}
