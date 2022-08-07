// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/

package DSApractice.Sorting.Easy;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array_448 {

    public List<Integer> findDisappearedNumbersLeet(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            // if number already exists then the place of that number will already be more than n
            nums[(nums[i]-1) % n] += n;
        }
        // at the end only repeated number position will have number <= n

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= n) {
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] res = new int[nums.length + 1];

        for (int num : nums) {  // mark index which are present
            res[num] = num;
        }

        List<Integer> result = new ArrayList<>(res.length);
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}