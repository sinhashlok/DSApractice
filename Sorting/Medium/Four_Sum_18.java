package DSApractice.Sorting.Medium;

import java.util.*;

public class Four_Sum_18 {

    /*
    * Why to sort the array first?
    * - it's easier to deal with duplicates if the array is sorted: repeated values are next to each other and easy to skip.
    *
    * For 3Sum, we enumerate each value in a single loop, and use the two pointers pattern for the rest of the array.
    * For "kSum", we will have k - 2 nested loops to enumerate all combinations of k - 2 values.
    *
    * IDEA:
    *   We can implement k - 2 loops using a recursion.
    *   We will pass the starting point and k as the parameters.
    *   When k == 2, we will call twoSum, terminating the recursion.
    *
    * Algorithm
    * Main function:
    *   - Sort the input array nums.
    *   - Call kSum with start = 0, k = 4, and target, and return the result.
    *
    * For kSum function:
    *  - At the start of the kSum function we will check three conditions
    *       1. Have we run out of numbers to choose from?
    *       2. Is the smallest number remaining greater than target / k?
    *          If so, then any k numbers we choose will be too large.
    *       3. Is the largest number remaining smaller than target / k?
    *          If so, then any k numbers we choose will be too small.
    *       # If any of these conditions is true, there is no need to continue as no combination
    *         of the remaining elements can sum to target.
    *
    * - If k equals 2, call twoSum and return the result.
    * - Iterate i through the array from start:
    *       # If the current value is the same as the one before, skip it.
    *       # Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i]
    *       # For each returned subset values:
    *           # Include the current value nums[i] into subset.
    *           # Add subset to the result res.
    * - Return the result res
    */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
//                                      arr      target sum     0         4 Sum
        List<List<Integer>> list = new ArrayList<>();

        // If we have run out of numbers to add, return res
        if (start == nums.length) {
            return list;
        }

        // There are k remaining values to add to the sum.
        // The average of these values is at least target / k.
        long averageValue = target / k;

        // We cannot obtain a sum of target if
        // the smallest value in nums is greater than target / k or
        // the largest value in nums is smaller than target / k.
        if (nums[start] > averageValue || nums[nums.length - 1] < averageValue) {
            return list;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            // skip repeating elements
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    // this adds the current element
                    list.add(new ArrayList<>(Arrays.asList(nums[i])));

                    // this adds the list returned (the two sum elements, which are inside the three sum list)
                    list.get(list.size() - 1).addAll(subset);
                }
            }
        }

        return list;
    }
    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> list = new ArrayList<>();
        int l = start, h = nums.length - 1;

        while (l < h) {
            int currSum = nums[l] + nums[h];

            if (currSum < target || (l > start && nums[l] == nums[l - 1])) {
                ++l;
            } else if (currSum > target || (h < nums.length - 1 && nums[h] == nums[h + 1])) {
                --h;
            } else {
                list.add(Arrays.asList(nums[l++], nums[h--]));
            }
        }

        return list;
    }


    // using hashSet
    public List<List<Integer>> fourSumHashSet(int[] nums, int target) {
        Arrays.sort(nums);
        return kSumHashSet(nums, target, 0, 4);
    }
    public List<List<Integer>> kSumHashSet(int[] nums, long target, int start, int k) {
//                                      arr      target sum     0         4 Sum
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum.
        // The average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if
        // the smallest value in nums is greater than target / k or
        // the largest value in nums is smaller than target / k.
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSumHashSet(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSumHashSet(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }
    public List<List<Integer>> twoSumHashSet(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int)target - nums[i], nums[i]));
                }
            }

            s.add((long)nums[i]);
        }

        return res;
    }
}