package DSApractice.LeetCode.Sorting.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic_Subarrays_1630 {


    // My approach
        // take parts of array in new array
        // sort new array
        // check difference
    public List<Boolean> checkArithmeticSubarraysMY(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[(r[i] - l[i]) + 1];

            int index = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                arr[index++] = nums[j]; // adding elements in new array
            }

            Arrays.sort(arr);   // sort
            int res = arr[1] - arr[0];
            boolean flag = true;

            for (index = 1; index < arr.length; index++) {
                if (res != arr[index] - arr[index - 1]) {   // check difference
                    flag = false;
                }

                if (!flag) {
                    list.add(false);
                    break;
                }
            }

            if (flag) {
                list.add(flag);
            }
        }

        return list;
    }


}