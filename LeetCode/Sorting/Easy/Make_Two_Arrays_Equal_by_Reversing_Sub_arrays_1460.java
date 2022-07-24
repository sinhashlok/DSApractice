// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

package DSApractice.LeetCode.Sorting.Easy;

import java.util.HashMap;
import java.util.Map;

public class Make_Two_Arrays_Equal_by_Reversing_Sub_arrays_1460 {

    // My Approach
    public boolean canBeEqualMY(int[] target, int[] arr) {
         Map<Integer, Integer> map = new HashMap<>();

         for (int x : arr)
             map.put(x, map.getOrDefault(x, 0) + 1);

         for (int t : target)
         {
             if (map.get(t) == null)
                 return false;
             else
             {
                 map.put(t, map.getOrDefault(t, 0) - 1);
                 if (map.get(t) == 0)
                     map.remove(t);
             }
         }

         return true;
    }

        // LeetCode
    public boolean canBeEqualLeet(int[] target, int[] arr) {
        int[] countMap = new int[1001]; //Map that holds count of ints

        //Iterate through the arrays
        for(int i = 0; i < target.length; i++) {
            countMap[target[i]]++; //Increment count of int found in target array
            countMap[arr[i]]--; //Decrement count of int found in arr array
        }

        //Iterate countMap
        for(int i : countMap) {
            if (i != 0) { //If not 0, it means target and arr do not match
                return false; //Return false
            }
        }

        //If this point is reached, the arrays are equal
        return true;
    }
}